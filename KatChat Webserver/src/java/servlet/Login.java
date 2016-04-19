package servlet;



public class Login {
	private String userName;
	private String password;
	private String sessionId;
	private String valid;
	
	public Login(){
		this.userName = "";
		this.password = "";
		this.sessionId = "";
		this.valid = "";
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String userType) {
		this.sessionId = userType;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String userID) {
		this.valid = userID;
	}
	
	
}
