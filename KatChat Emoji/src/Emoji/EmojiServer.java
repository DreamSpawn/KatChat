package Emoji;

import java.rmi.Naming;

public class EmojiServer
{
	public static void main(String[] arg) throws Exception
	{
		// Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
		java.rmi.registry.LocateRegistry.createRegistry(1099); // start i server-JVM

		EmojiI emoji = new EmojiLogik();
		Naming.rebind("rmi://localhost/emoji", emoji);
		System.out.println("Emoji Server added.");
	}
}