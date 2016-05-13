/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.util.ArrayList;


/**
 *
 * @author JoachimØstergaard
 */
public interface IKatServer extends java.rmi.Remote{
	public static final int PORT = 4092;
	public static final String HOST = "ubuntu4.javabog.dk";
	//public static final String HOST = "localhost";
	public static final String SERVICE = "kat_chat";
	public static final String FULL_ADDRESS = "rmi://" + HOST + ":" + PORT + "/" + SERVICE;
	
    public int login(String name, String password) throws java.rmi.RemoteException;
    public ArrayList<String> getMessage( int session) throws java.rmi.RemoteException;
    public void sentMessage(String message, int session) throws java.rmi.RemoteException;
}
