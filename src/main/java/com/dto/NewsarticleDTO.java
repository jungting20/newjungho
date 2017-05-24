package com.dto;

public class NewsarticleDTO {
	
	private String newscompany;
	private String newscategory;
	private String newsrssaddress;
	public String getNewscompany() {
		return newscompany;
	}
	public void setNewscompany(String newscompany) {
		this.newscompany = newscompany;
	}
	public String getNewscategory() {
		return newscategory;
	}
	public void setNewscategory(String newscategory) {
		this.newscategory = newscategory;
	}
	public String getNewsrssaddress() {
		return newsrssaddress;
	}
	public void setNewsrssaddress(String newsrssaddress) {
		this.newsrssaddress = newsrssaddress;
	}
	public NewsarticleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewsarticleDTO(String newscompany, String newscategory, String newsrssaddress) {
		super();
		this.newscompany = newscompany;
		this.newscategory = newscategory;
		this.newsrssaddress = newsrssaddress;
	}
	
	
	
	
}
