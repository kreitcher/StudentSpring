package com.bean;

public class Marks {
	int id;
	String rollNo;
	String courseCode;
	int marks;
	
	public Marks(String rollNo, String courseCode, int marks){
		this.id=-1;
		this.rollNo = rollNo;
		this.courseCode = courseCode;
		this.marks = marks;
	}
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getId() {
		return id;
	}	
}
