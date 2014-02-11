package com.bean;


public class Student {
	int id;
	String rollNo;
	String name;
	
	
	public Student(String rollNo, String name){
		this.id=-1;
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public Student(int id, String rollNo, String name){
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// read only (PK)
	public int getId(){
		return id;
	}
	
	@Override
	public String toString() {
		return rollNo+" | "+name;
	}
	
}
