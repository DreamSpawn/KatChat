/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mikkel
 */
public class SessionList {
	Map<String,Integer> NameToId = new HashMap<>();
	Map<Integer,SessionInfo> IdToInfo = new HashMap<>();
	
	
	public boolean put(String name, int id){
		if (!(NameToId.containsKey(name) || IdToInfo.containsKey(id))){
			NameToId.put(name, id);
			SessionInfo newInfo = new SessionInfo();
			newInfo.id = id;
			newInfo.name = name;
			newInfo.lastMessage = 0;
			IdToInfo.put(id,newInfo);
			return true;
		}
		return false;
	}
	
	public boolean update(int id, SessionInfo info){
		if (NameToId.containsKey(info.name) && IdToInfo.containsKey(id)){
			IdToInfo.put(id, info);
			return true;
		}
		return false;
	}
	
	/**
	 *
	 * @param id
	 * @return
	 */
	public SessionInfo getSession(int id){
		return IdToInfo.get(id);
	}
	
	public Integer getId(String name){
		return NameToId.get(name);
	}
	
	public Set<Map.Entry<Integer,SessionInfo>> entrySet() {
		return IdToInfo.entrySet();
	}
	
	public void setRecievedMessages(String name, int msgNo){
		
	}
	
}
