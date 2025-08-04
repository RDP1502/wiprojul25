package com.wipro.firstboot.model1;


public class User {
	
	String userName;
	String userPass;
	String userPhoneNumber;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPass=" + userPass + ", userPhoneNumber=" + userPhoneNumber + "]";
	}
	
	
	 
}