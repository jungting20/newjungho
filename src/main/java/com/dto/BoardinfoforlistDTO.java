package com.dto;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class BoardinfoforlistDTO {
	
	private int page;
	private int perpagelist;
	private String search;
	private String searchtype;
	private String category;
	
	
	
	
	@Override
	public String toString() {
		return "BoardinfoforlistDTO [page=" + page + ", perpagelist=" + perpagelist + ", search=" + search
				+ ", searchtype=" + searchtype + ", category=" + category + "]";
	}


	public BoardinfoforlistDTO(int page, int perpagelist, String search, String searchtype, String category) {
		super();
		this.page = page;
		this.perpagelist = perpagelist;
		this.search = search;
		this.searchtype = searchtype;
		this.category = category;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public BoardinfoforlistDTO() {
		this.page = 1;
		this.perpagelist = 10;
		this.searchtype = "title";
		// TODO Auto-generated constructor stub
	}


	public BoardinfoforlistDTO(int page, int perpagelist, String search, String searchtype) {
		super();
		this.page = page;
		this.perpagelist = perpagelist;
		this.search = search;
		this.searchtype = searchtype;
	}
	
	
	public int getPage() {
		return page;
	}
	public int getStart(){
		
		return (getPage()-1)*getPerpagelist()+1;
	}
	public int getEnd(){
		
		return getStart()+getPerpagelist()-1;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public int getPerpagelist() {
		return perpagelist;
	}


	public void setPerpagelist(int perpagelist) {
		this.perpagelist = perpagelist;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	public String getSearchtype() {
		return searchtype;
	}


	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	
	



	
	
	
	
	
}
