package com.dto;

public class BoardDTO {
		
	private int id;
	private String title;
	private String writer_id;
	private String content;
	private String filepath;
	private String category;
	private String written_date;
	private int readcnt;
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDTO(int id, String title, String writer_id, String content, String filepath, String category,
			String written_date, int readcnt) {
		super();
		this.id = id;
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
		this.filepath = filepath;
		this.category = category;
		this.written_date = written_date;
		this.readcnt = readcnt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getWritten_date() {
		return written_date;
	}
	public void setWritten_date(String written_date) {
		this.written_date = written_date;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	
	
	
	
}
