/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mikkel
 */
public class UserDatabaseMap implements IUserDataBase{

	private static final Map<String,String> USERS = new HashMap<>();
	
	@Override
	public boolean hasUser(String name, String password) {
		return (USERS.containsKey(name) && USERS.get(name).equals(password));
	}

	@Override
	public boolean addUser(String name, String password) {
		return USERS.put(name, password) == null;
	}
}
