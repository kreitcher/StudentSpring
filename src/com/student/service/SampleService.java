package com.student.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.dao.StudentDAOImpl;

public class SampleService {
	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");
		StudentDAOImpl studentDAO = (StudentDAOImpl)context.getBean("studentBean");
		studentDAO.createStudent("14PH2345", "Alpha");
		studentDAO.createStudent("14PH2346", "Bravo");
		studentDAO.createStudent("14PH2347", "Charlie");
		studentDAO.createStudent("14PH2348", "Alpha Q");
		studentDAO.createStudent("14CS4411", "Romeo");
		studentDAO.createStudent("14CS4412", "Tango");
		studentDAO.createStudent("14CS4413", "Juliet");
		studentDAO.createStudent("14CS4414", "Lima");
		
		System.out.println(studentDAO.listStudents());
		System.out.println(studentDAO.getStudent("14CS4412"));
		System.out.println(studentDAO.getStudent("14CS4414"));
		
		studentDAO.updateStudentName("14PH2346", "Bravo B");
		studentDAO.updateStudentName("14PH2348", "14PH2350-");
		
		System.out.println(studentDAO.listStudents());
		
	}
}
