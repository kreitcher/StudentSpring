package com.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.app.context.ApplicationContextProvider;
import com.bean.Course;
import com.course.dao.CourseDAOImpl;

public class CourseService {
	CourseDAOImpl courseDAO;
	List<Course> courseList;
	Course course;
	
	public CourseService() {
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		courseDAO = (CourseDAOImpl)context.getBean("courseDAO");
	}
	
	public List<Course> addCourse(Course course){
		courseDAO.createCourse(course);
		courseList = new ArrayList<Course>();
		course = courseDAO.getCourse(course.getCourseCode());
		courseList.add(course);
		return courseList;
	}
	
	public List<Course> searchCourse(String courseCode){
		courseList = new ArrayList<Course>();
		course = courseDAO.getCourse(courseCode);
		courseList.add(course);
		return courseList;
	}
	
	public List<Course> listCourse(){
		courseList = courseDAO.listCourses();
		return courseList;
	}
}
