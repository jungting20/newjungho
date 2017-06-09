package com.dto;

public class FileUploadDTO {
	
	
	private String originalfilename;
	private String realuploadpath;
	private String uploadedfilename;
	private int id;
	private String uploaddate;

	
	
	
	public FileUploadDTO(String originalfilename, String realuploadpath, String uploadedfilename, String uploaddate) {
		super();
		this.originalfilename = originalfilename;
		this.realuploadpath = realuploadpath;
		this.uploadedfilename = uploadedfilename;
		this.uploaddate = uploaddate;
	}

	public String getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FileUploadDTO(String originalfilename, String realuploadpath, String uploadedfilename, int id) {
		super();
		this.originalfilename = originalfilename;
		this.realuploadpath = realuploadpath;
		this.uploadedfilename = uploadedfilename;
		this.id = id;
	}

	public FileUploadDTO(String originalfilename, String realuploadpath, String uploadedfilename) {
		super();
		this.originalfilename = originalfilename;
		this.realuploadpath = realuploadpath;
		this.uploadedfilename = uploadedfilename;
	}

	public String getUploadedfilename() {
		return uploadedfilename;
	}

	public void setUploadedfilename(String uploadedfilename) {
		this.uploadedfilename = uploadedfilename;
	}

	public FileUploadDTO(String originalfilename, String realuploadpath) {
		super();
		this.originalfilename = originalfilename;
		this.realuploadpath = realuploadpath;
	}

	public String getRealuploadpath() {
		return realuploadpath;
	}

	public void setRealuploadpath(String realuploadpath) {
		this.realuploadpath = realuploadpath;
	}

	public String getOriginalfilename() {
		return originalfilename;
	}

	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}

	public FileUploadDTO(String originalfilename) {
		super();
		this.originalfilename = originalfilename;
	}

	public FileUploadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
