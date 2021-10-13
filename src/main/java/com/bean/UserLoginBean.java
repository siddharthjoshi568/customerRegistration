package com.bean;

public class UserLoginBean {
	private String userLoginId;
	private String password;
	private int partyId;
	
	public UserLoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLoginBean(String userLoginId, String password) {
		super();
		this.userLoginId = userLoginId;
		this.password = password;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	@Override
	public String toString() {
		return "UserLoginBean [userLoginId=" + userLoginId + ", password=" + password + ", partyId=" + partyId + "]";
	}
	
	
}
