package com.cmpe283.project;


public class ESXI {

	private String ip;
	private String user;
	private String password;
	
	public ESXI(String ip, String user, String password)
	{
		this.ip = ip;
		this.user = user;
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
