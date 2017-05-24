package com.dto;

public class ArticleCommentDTO {

	
	private String commentid;
	private String author;
	private String content;
	private String root;
	private String indent;
	private String commentlevel;
	private String link;
	
	
	
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getIndent() {
		return indent;
	}
	public void setIndent(String indent) {
		this.indent = indent;
	}
	public String getCommentlevel() {
		return commentlevel;
	}
	public void setCommentlevel(String commentlevel) {
		this.commentlevel = commentlevel;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public ArticleCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleCommentDTO(String commentid, String author, String content, String root, String indent,
			String commentlevel, String link) {
		super();
		this.commentid = commentid;
		this.author = author;
		this.content = content;
		this.root = root;
		this.indent = indent;
		this.commentlevel = commentlevel;
		this.link = link;
	}
	
	
	
		
}
