package com.acorn.common;

public class ErrorMessage {
	
	private String errstatus;
	private String emessage;
	
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(String errstatus, String emessage) {
		super();
		this.errstatus = errstatus;
		this.emessage = emessage;
	}
	public String getErrstatus() {
		return errstatus;
	}
	public void setErrstatus(String errstatus) {
		this.errstatus = errstatus;
	}
	public String getEmessage() {
		return emessage;
	}
	public void setEmessage(String emessage) {
		this.emessage = emessage;
	}
	
	
}
