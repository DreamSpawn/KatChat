/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.rmi.*;
import java.rmi.server.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import brugerautorisation.data.Bruger;
import java.net.MalformedURLException;
/**
 *
 * @author Mikkel
 */
public class ServerLogic extends UnicastRemoteObject implements IKatServer {

	private static SessionList current_users = new SessionList();
	public static List<String> messages = new ArrayList<>();

	private static final IUserDataBase USERS = new UserDatabaseMap();

	public ServerLogic() throws RemoteException {
		USERS.addUser("Konstantin", "mypassword");
		USERS.addUser("Mikkel", "hispassword");
		USERS.addUser("demo", "password");
		USERS.addUser("Kim", "herspassword");
		USERS.addUser("Joakim", "ijdovbibszovhob120932349oi8yeSDVV!");
		USERS.addUser("Teacher", "qwerty");
		USERS.addUser("null", "");
	}

	@Override
	public int login(String name, String password) throws RemoteException {
		if (USERS.hasUser(name, password)){
			return getSessionId(name);
		} else {
			return -1;
		}
	}

	@Override
	public ArrayList<String> getMessage(int session) throws RemoteException {
		SessionInfo info = current_users.getSession(session);
		if (info != null) {
			if (info.lastMessage == messages.size()) {
				synchronized (messages) {
					try {
						messages.wait();
					} catch (InterruptedException ex) {
					}
				}
			}
			ArrayList<String> returnMessages = new ArrayList<>(
					messages.subList(info.lastMessage, messages.size()));
			info.lastMessage = messages.size();
			current_users.update(session, info);
			return returnMessages;
		}
		return null;
	}

	@Override
	public void sentMessage(String message, int session) throws RemoteException {
		System.out.println("Message recieved from:" + session + "\nMessage:" + message);
		SessionInfo info = current_users.getSession(session);
                Analyse am = new Analyse();
                
            try {
                String analyseM =am.analyse(message,info.name);
            } catch (Exception ex) {
                Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
		if (info == null || am.equals("")) {
			return;
		}

		message = info.name + ": " + am;
		synchronized (messages) {
			messages.add(message);
			messages.notifyAll();
		}
	}

	private int getSessionId(String username) {
		if (current_users.getId(username) != null) {
			return current_users.getId(username);
		}

		Random rand = new Random();

		int id;
		do {
			id = rand.nextInt();
		} while (current_users.getSession(id) != null);

		current_users.put(username, id, messages.size());
		return id;
	}

	private void printCurrentUsers() {
		for (Map.Entry<Integer, SessionInfo> entry : current_users.entrySet()) {
			int session_id = entry.getKey();
			String username = entry.getValue().name;
			System.out.println("session Id " + session_id + " username " + username + "\n");
		}
	}

}
