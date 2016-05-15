package Emoji;

import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Random;

public class EmojiLogik extends UnicastRemoteObject implements IEmoji {

	private final ArrayList<emoji> emojiList;
	public static final String MESSAGE = "Hello World";

	public String getMessage() {
		return MESSAGE;
	}

	public EmojiLogik() throws java.rmi.RemoteException {
		this.emojiList = new ArrayList<>();
		emojiList.add(new emoji(">'.'<", "cat1"));
		emojiList.add(new emoji("=^,^=", "cat2"));
		emojiList.add(new emoji(">O_O<", "cat3"));
	}

	/**
	 *
	 * @param emojipic
	 * @param name
	 * @throws RemoteException
	 */
	@Override
	public void addCat(String emojipic, String name) throws java.rmi.RemoteException {
		for (int i = 0; i < emojiList.size(); i++) {
			if (emojiList.get(i).getName().equalsIgnoreCase(name)) {
				return;
			}
		}
		emoji temp = new emoji(emojipic, name);
		emojiList.add(temp);
	}

	/**
	 *
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public String getCat() throws java.rmi.RemoteException {
		// tilføj random generator her
		Random rand = new Random();
		int i = rand.nextInt(emojiList.size());
		return emojiList.get(i).getEmoji();
	}

	/**
	 *
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public String getCat(String name) throws java.rmi.RemoteException {
		for (int i = 0; i < emojiList.size(); i++) {
			if (emojiList.get(i).getName().equals(name)) {
				return emojiList.get(i).getEmoji();
			}

		};
		return emojiList.get(0).getEmoji();
	}

	/**
	 *
	 * @param index
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public String getCat(int index) throws java.rmi.RemoteException {
		return emojiList.get(index).getEmoji();
	}

}
