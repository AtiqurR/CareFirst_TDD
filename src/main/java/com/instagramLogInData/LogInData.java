package com.instagramLogInData;

public class LogInData {

	private String userName;
	private String passWord;
	
	public LogInData(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

}
