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

        public int login(String name, String password) throws java.rmi.RemoteException;

        public String getMessage( int session) throws java.rmi.RemoteException;

        public void sentMessage(String message, int session) throws java.rmi.RemoteException;


}
}
