package com.course.dao;

import javax.sql.DataSource;

import com.bean.Course;

public interface CourseDAO {
	
	/**
	 * Connection
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource);
	
	/** CRUD ops */
	
	/** Create **/
	/**
	 * create course with raw data
	 * @param rollNo
	 * @param name
	 */
	public void createCourse(String courseCode, String courseName);
	
	/**
	 * create course with Course object
	 * @param student
	 */
	public void createCourse(Course course);
	
	/** Read **/
	/**
	 * Get student from roll no
	 * @param rollNo
	 * @return
	 */
	public Course getCourse(String courseCode);
	
	/**
	 * Get course from PK
	 * @param id
	 * @return
	 */
	public Course getCourse(int id);
	
	/** Update **/
	/**
	 * update course name with roll No as reference
	 * @param rollNo
	 * @param name
	 */
	public void updateCourseName(String courseCode, String courseName);
	
	/**
	 * update course name with PK reference
	 * @param id
	 * @param name
	 */
	public void updateCourseName(int id, String courseName);
	
	/**
	 * replacing course code with old course code reference
	 * @param courseCodeOld
	 * @param courseCodeNew
	 */
	public void updateCourseCode(String courseCodeOld, String courseCodeNew);
	
	/**
	 * replace course code with PK reference
	 * @param id
	 * @param courseCode
	 */
	public void updateCourseCode(int id, String courseCode);
	
	/** Delete **/
	/**
	 * delete course with PK reference
	 * @param id
	 */
	public void deleteCourse(int id);
	
	/**
	 * delete course with course code reference
	 * @param courseCode
	 */
	public void deleteCourse(String courseCode);
}
