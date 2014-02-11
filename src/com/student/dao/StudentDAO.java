package com.student.dao;

import javax.sql.DataSource;

import com.bean.Student;

public interface StudentDAO {
	/**
	 * Connection
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource);
	
	/** CRUD Ops **/
	
	/** Create **/
	/**
	 * create student with raw data
	 * @param rollNo
	 * @param name
	 */
	public void createStudent(String rollNo, String name);
	
	/**
	 * create student with Student object
	 * @param student
	 */
	public void createStudent(Student student);
	
	/** Read **/
	/**
	 * Get student from roll no
	 * @param rollNo
	 * @return
	 */
	public Student getStudent(String rollNo);
	
	/**
	 * Get student from PK
	 * @param id
	 * @return
	 */
	public Student getStudent(int id);
	
	/** Update **/
	/**
	 * update student name with roll No as reference
	 * @param rollNo
	 * @param name
	 */
	public void updateStudentName(String rollNo, String name);
	
	/**
	 * update student name with PK reference
	 * @param id
	 * @param name
	 */
	public void updateStudentName(int id, String name);
	
	/**
	 * replace roll no with PK reference
	 * @param id
	 */
	public void updateStudentRollNo(int id, String rollNo);
	
	/**
	 * replace roll no with old roll no reference
	 * @param rollNoOld
	 * @param rollNoNew
	 */
	public void updateStudentRollNo(String rollNoOld, String rollNoNew);
	
	/** Delete **/
	/**
	 * delete student with PK reference
	 * @param id
	 */
	public void deleteStudent(int id);
	
	/**
	 * delete student with roll no reference
	 * @param rollNo
	 */
	public void deleteStudent(String rollNo);
}
