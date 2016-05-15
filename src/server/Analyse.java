/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Emoji.EmojiI;
import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoachimØstergaard
 */
public class Analyse {
 
    public String analyse(String message, String name) throws Exception{
        
        if(!message.equals("")){
        if(message.charAt(0) == '!'){
            EmojiI emoji =(EmojiI) Naming.lookup(EmojiI.FULL_ADDRESS);
            if(message.charAt(1)== 'E'||message.charAt(1)== 'e'){
                String[] messageSplit = message.split(" ");
                if(messageSplit[1].equalsIgnoreCase("random")){
                return emoji.getCat();
            }
                if(messageSplit[1].equalsIgnoreCase("save")){
                    
                    emoji.addCat(messageSplit[2], messageSplit[3]);
                return "I added a new cat is added "+messageSplit[2]+" - "+messageSplit[3];
            }else{
                    return emoji.getCat(messageSplit[1]);
                }
                    
            }
            
        }if(message.charAt(0) == '/'){
            String[] messageSplit = message.split(" ",3);
                
            if(messageSplit[0].equals("/password")){
             Brugeradmin ba;
                try {
                ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
               ba.ændrAdgangskode(name, messageSplit[1],messageSplit[2]);
                
			
            } catch (NotBoundException ex) {
                Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ServerLogic.class.getName()).log(Level.SEVERE, null, ex);
            }   
            }
            return "";
        }
        }
        
        return message;
    }
}
/*

	public void addCat(String cat,String name) throws java.rmi.RemoteException;
	public String getCat() throws java.rmi.RemoteException;
	public String getCat(String name) throws java.rmi.RemoteException;
	public String getCat(int index) throws java.rmi.RemoteException;
*/