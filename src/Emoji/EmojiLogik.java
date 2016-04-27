package Emoji;

import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;
import Emoji.emoji;

public class EmojiLogik extends UnicastRemoteObject implements EmojiI{
	
	private ArrayList<emoji> emojiList = new ArrayList<emoji>();
	public static final String MESSAGE = "Hello World";

	public String getMessage() {
		return MESSAGE;
	}

	public EmojiLogik() throws java.rmi.RemoteException  {
		emojiList.add(new emoji( ">'.'<",	"cat1"));
		emojiList.add(new emoji( "=^,^=",	"cat2"));
		emojiList.add(new emoji( ">O_O<",	"cat3"));
	}

	public void addCat(String emojipic, String name)throws java.rmi.RemoteException  {
		emoji temp = new emoji(emojipic,name);
		emojiList.add(temp);
	}

	public String getCat()throws java.rmi.RemoteException  {
		// tilføj random generator her
		return emojiList.get(0).getEmoji();
	}

	public String getCat(String name) throws java.rmi.RemoteException {
		for(int i = 0;i<emojiList.size();i++){
			if(emojiList.get(i).getName().equals(name))emojiList.get(i).getEmoji();
		}; 
		return emojiList.get(0).getEmoji();
	}

	public String getCat(int index) throws java.rmi.RemoteException {
		return emojiList.get(index).getEmoji();
	}




}
