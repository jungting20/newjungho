package com.dto;

public class LoginDTO {
	
	
	private String userid;
	private String passwd;
	private String isautologin;
	
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getIsautologin() {
		return isautologin;
	}
	public void setIsautologin(String isautologin) {
		this.isautologin = isautologin;
	}
	public LoginDTO(String userid, String passwd, String isautologin) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.isautologin = isautologin;
	}
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
