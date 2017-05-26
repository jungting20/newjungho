package com.dto;

import java.util.List;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class BoardpageDTO {
	
	private int totalcount;
	private int displaypage;
	private Boolean prev;
	private Boolean next;
	private int endpage;
	private int startpage;
	private BoardinfoforlistDTO binfo;
	private List<BoardDTO> list;
	
	
	
	
	public BoardpageDTO() {
		this.displaypage = 10;
		this.endpage=10;
		this.startpage=1;
		
		
	}
	
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	public int getDisplaypage() {
		return displaypage;
	}
	public void setDisplaypage(int displaypage) {
		this.displaypage = displaypage;
	}
	public BoardpageDTO(int totalcount, int perpagenumber, Boolean prev, Boolean next, int endpage, int startpage,
			BoardinfoforlistDTO binfo) {
		super();
		this.totalcount = totalcount;
		this.displaypage = perpagenumber;
		this.prev = prev;
		this.next = next;
		this.endpage = endpage;
		this.startpage = startpage;
		this.binfo = binfo;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
		int lastpage = totalcount%binfo.getPerpagelist()==0?
				totalcount/binfo.getPerpagelist():totalcount/binfo.getPerpagelist()+1;
		int temp = binfo.getPage()%this.displaypage==0?
				binfo.getPage():((binfo.getPage()/this.displaypage)+1)*this.displaypage;
		if(temp>=lastpage){
			this.endpage = lastpage;
		}else{
			this.endpage = temp;
		}
		
		this.startpage = endpage - (this.displaypage-1);
		this.prev = binfo.getPage()==1?false:true;
		this.next = binfo.getPage()==lastpage?false:true;
		
		
	}
	public int getPerpagenumber() {
		return displaypage;
	}
	public void setPerpagenumber(int perpagenumber) {
		this.displaypage = perpagenumber;
	}
	public Boolean getPrev() {
		return prev;
	}
	public void setPrev(Boolean prev) {
		this.prev = prev;
	}
	public Boolean getNext() {
		return next;
	}
	public void setNext(Boolean next) {
		this.next = next;
	}
	public int getEndpage() {
		return endpage;
	}
	
	public int getStartpage() {
		return startpage;
	}
	
	public BoardinfoforlistDTO getBinfo() {
		return binfo;
	}
	public void setBinfo(BoardinfoforlistDTO binfo) {
		this.binfo = binfo;
		
	}
	public String urimaker(BoardinfoforlistDTO dto){
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", dto.getPage())
				.queryParam("perpagelist", dto.getPerpagelist())
				.queryParam("search", dto.getSearch())
				.queryParam("searchtype", dto.getSearchtype())
				.build();
		
		return uri.toUriString();
	}
	
	
	
}
