package com.bean;

public class Course {
	int id;
	String courseCode;
	String courseName;
	
	public Course(String courseCode, String courseName){
		this.id=-1;
		this.courseCode = courseCode;
		this.courseName = courseName;
	}
	
	public Course(int id, String courseCode, String courseName){
		this.id = id;
		this.courseCode = courseCode;
		this.courseName = courseName;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	//read only (PK)
	public int getId(){
		return id;
	}
	
}
