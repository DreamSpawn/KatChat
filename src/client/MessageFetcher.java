/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import server.IKatServer;

/**
 *
 * @author Mikkel
 */
public class MessageFetcher implements Runnable{

	JTextArea textArea;
	IKatServer server;
	int session;
	
	public MessageFetcher(IKatServer server, JTextArea textArea, int session){
		this.server = server;
		this.textArea = textArea;
		this.session = session;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				List<String> messages = server.getMessage(session);
				for(String msg : messages){
					textArea.setText(textArea.getText()+ "\n" + msg);
				}
			} catch (RemoteException ex) {
			}
		}
	}
	
}
