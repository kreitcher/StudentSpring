package com.marks.dao;

import java.util.List;
import javax.sql.DataSource;
import com.bean.Course;
import com.bean.Marks;
import com.bean.Student;

public interface MarksDAO {

	/**
	 * setting the connection
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * creating a row
	 * @param rollNo
	 * @param courseCode
	 * @param marks
	 */
	public void createMarksEntry(String rollNo, String courseCode, int marks);
	
	/**
	 * creating a row with a Marks object
	 * @param marks
	 */
	public void createMarksEntry(Marks marks);
	
	/**
	 * Gets the list of courses for a given student.
	 * @param rollNo
	 * @return
	 */
	public List<Course> getCourseList(String rollNo);
	
	/**
	 * Gets a list of Students for a given course.
	 * @param courseCode
	 * @return
	 */
	public List<Student> getStudentList(String courseCode);
	
	/**
	 * Updates marks given the roll no and course code.
	 * @param rollNo
	 * @param courseCode
	 * @param marks
	 */
	public void updateMarks(String rollNo, String courseCode, int marks);
	
	/**
	 * removes all entries in marks with the given course code.
	 * @param courseCode
	 */
	public void deleteCourseEntries(String courseCode);
	
	/**
	 * deletes all entries in marks for the given roll no.
	 * @param rollNo
	 */
	public void deleteStudentEntries(String rollNo);
	
	/**
	 * deletes a single entry for a given roll no and course code.
	 * @param rollNo
	 * @param courseCode
	 */
	public void deleteEntry(String rollNo, String courseCode);
	
	/**
	 * deletes 
	 * @param marks
	 */
	public void deleteEntry(Marks marks);
}