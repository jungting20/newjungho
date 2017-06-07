package com.dto;

public class FileUploadDTO {
	
	
	private String originalfilename;

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
