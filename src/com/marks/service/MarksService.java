package com.marks.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.app.context.ApplicationContextProvider;
import com.bean.Course;
import com.bean.Marks;
import com.bean.Student;
import com.marks.dao.MarksDAOImpl;

public class MarksService {

	MarksDAOImpl marksDAO ;
	List<Marks> marksList;
	Marks marks;
	
	public MarksService(){
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		marksDAO = (MarksDAOImpl)context.getBean("marksDAO");
	}
	
	public List<Marks> addRecord(Marks marksObject){
		marksDAO.createMarksEntry(marksObject);
		marks = marksDAO.getRecord(marksObject.getRollNo(), marksObject.getCourseCode());
		marksList = new ArrayList<Marks>();
		marksList.add(marks);
		return marksList;
	}
	
	public List<Student> getStudentList(String courseCode){
		return marksDAO.getStudentList(courseCode);
	}
	
	public List<Course> getCourseList(String rollNo) {
		return marksDAO.getCourseList(rollNo);
	}
	
	public List<Marks> getAllRecords(){
		return marksDAO.listRecords();
	}
}
