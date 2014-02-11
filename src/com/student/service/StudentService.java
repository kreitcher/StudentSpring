package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.app.context.ApplicationContextProvider;
import com.bean.Student;
import com.student.dao.StudentDAOImpl;


public class StudentService {
	StudentDAOImpl studentDAO;
	Student student;
	List<Student> studentList;
	
	public StudentService(){
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		studentDAO = (StudentDAOImpl)context.getBean("studentDAO");
	}
	
	public List<Student> addRecord(String rollNo, String name){
		student = new Student(rollNo, name);
		studentDAO.createStudent(student);
		studentList = new ArrayList<Student>();
		studentList.add(student);
		return studentList;
	}
	
	public List<Student> searchRecords(String rollNo){
		student = studentDAO.getStudent(rollNo);
		studentList = new ArrayList<Student>();
		studentList.add(student);
		return studentList;
	}
	
	public List<Student> listRecords(){
		studentList = studentDAO.listStudents();
		return studentList;
	}
	
}
