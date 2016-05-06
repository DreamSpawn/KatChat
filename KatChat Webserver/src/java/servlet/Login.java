package servlet;



public class Login {
	private String userName;
	private String password;
	private int sessionId;
	private boolean valid;
	
	public Login(){
		this.userName = "";
		this.password = "";
		this.sessionId = -1;
		this.valid = false;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public String getPassword(){
		return this.password;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int id) {
		this.sessionId = id;
	}

	public boolean getValid() {
		return valid;
	}

	public void setValid(boolean userID) {
		this.valid = userID;
	}
	
	
}
