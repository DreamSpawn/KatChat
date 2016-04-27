package Emoji;

import java.rmi.Naming;
import java.util.Scanner;

public interface EmojiI extends java.rmi.Remote {

	public void addCat(String cat,String name) throws java.rmi.RemoteException;
	public String getCat() throws java.rmi.RemoteException;
	public String getCat(String name) throws java.rmi.RemoteException;
	public String getCat(int index) throws java.rmi.RemoteException;

}
