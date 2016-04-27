package Emoji;

import java.rmi.Naming;

public class EmojiTest {

	public static void main(String[] args) throws Exception {

		EmojiI spil =(EmojiI) Naming.lookup("rmi://localhost/emoji");
		String cat =spil.getCat();
		System.out.println(cat); 

/*
		Galgelogik spil = new Galgelogik();
       	spil.nulstil();
      	Scanner scanner = new Scanner(System.in);
      	while (!spil.erSpilletSlut()) try {
        String valg = scanner.nextLine();
        scanner.nextLine();
        spil.gætBogstav(valg);
    	try {
      		spil.hentOrdFraDr();
    	} catch (Exception e) {	e.printStackTrace(); }
    	spil.logStatus();
      	}catch (Throwable t) { t.printStackTrace(); scanner.nextLine(); }
      		return;
*/
	}
}
