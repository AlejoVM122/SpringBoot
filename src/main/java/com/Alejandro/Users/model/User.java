package com.Alejandro.Users.model;


public class User {
	
	public String userName;
	public String password;
	public String nickName;
	
	
	
	public User () {
		
	}
	
	public User(String userName, String password, String nickName) {
		super();
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
}
