package Emoji;

import java.rmi.Naming;
import java.rmi.registry.Registry;


public class EmojiServer{
	private static final int PORT = EmojiI.PORT;
	private static final String HOST = EmojiI.HOST;
	private static final String SERVICE = EmojiI.SERVICE;
	private static final String FULL_ADDRESS = EmojiI.FULL_ADDRESS;

	public static void main(String[] arg) throws Exception
	{
		// Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:

                
                	System.setProperty("java.rmi.server.hostname", HOST);
		java.rmi.registry.LocateRegistry.createRegistry(PORT); // start i server-JVM
		EmojiI emoji = new EmojiLogik();
 		Naming.rebind(FULL_ADDRESS, emoji);
		System.out.println("Katserver registreret på port:" + PORT);
		Registry reg = java.rmi.registry.LocateRegistry.getRegistry(PORT);
		System.out.println(reg.lookup(SERVICE));
                
	}
}