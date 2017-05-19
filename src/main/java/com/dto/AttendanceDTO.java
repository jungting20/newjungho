package com.dto;

public class AttendanceDTO {
	
	private int id;
	private String student_id;
	private String course_id;
	private String tag_time;
	private String course_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getTag_time() {
		return tag_time;
	}
	public void setTag_time(String tag_time) {
		this.tag_time = tag_time;
	}
	public String getCourse_date() {
		return course_date;
	}
	public void setCourse_date(String course_date) {
		this.course_date = course_date;
	}
	public AttendanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttendanceDTO(int id, String student_id, String course_id, String tag_time, String course_date) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.course_id = course_id;
		this.tag_time = tag_time;
		this.course_date = course_date;
	}
	
	
	
	
}
