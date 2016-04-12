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
public class IKatServer {

    public interface GalgeI extends java.rmi.Remote {

        public ArrayList<String> getBrugteBogstaver() throws java.rmi.RemoteException;

        public String login() throws java.rmi.RemoteException;

        public String getOrdet() throws java.rmi.RemoteException;

        public int getAntalForkerteBogstaver() throws java.rmi.RemoteException;

        public boolean erSidsteBogstavKorrekt() throws java.rmi.RemoteException;

        public boolean erSpilletVundet() throws java.rmi.RemoteException;

        public boolean erSpilletTabt() throws java.rmi.RemoteException;

        public boolean erSpilletSlut() throws java.rmi.RemoteException;

        public void nulstil() throws java.rmi.RemoteException;

        public void gætBogstav(String bogstav) throws java.rmi.RemoteException;

        public void logStatus() throws java.rmi.RemoteException;

        public String getMessage() throws java.rmi.RemoteException;
    ;

}
}
