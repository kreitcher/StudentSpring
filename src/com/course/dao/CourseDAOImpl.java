package com.course.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.Course;

public class CourseDAOImpl implements CourseDAO{
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplateObject;
	String sql;
	Course course;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createCourse(String courseCode, String courseName) {
		createCourse(new Course(courseCode, courseName));		
	}

	@Override
	public void createCourse(Course course) {
		sql = "insert into Course(coursecode,coursename) values (?,?)";
		jdbcTemplateObject.update(sql,course.getCourseCode(), course.getCourseName());
	}

	@Override
	public Course getCourse(String courseCode) {
		sql = "select * from Course where coursecode = ?";
		course = jdbcTemplateObject.queryForObject(sql, new Object[]{courseCode}, new CourseMapper());
		return course;
	}

	@Override
	public Course getCourse(int id) {
		sql = "select * from Course where id = ?";
		course = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new CourseMapper());
		return course;
	}

	@Override
	public void updateCourseName(String courseCode, String courseName) {
		sql = "update Course set coursename = ? where coursecode = ?";
		jdbcTemplateObject.update(sql, courseName, courseCode);
	}

	@Override
	public void updateCourseName(int id, String courseName) {
		sql = "update Course set coursename = ? where id = ?";
		jdbcTemplateObject.update(sql, courseName, id);
	}

	@Override
	public void updateCourseCode(String courseCodeOld, String courseCodeNew) {
		sql = "update Course set coursecode = ? where coursecode = ?";
		jdbcTemplateObject.update(sql, courseCodeNew, courseCodeOld);
	}

	@Override
	public void updateCourseCode(int id, String courseCode) {
		sql = "update Course set coursecode = ? where id = ?";
		jdbcTemplateObject.update(sql, courseCode, id);
		
	}

	@Override
	public void deleteCourse(int id) {
		sql = "delete from Course where id = ?";
		jdbcTemplateObject.update(sql,id);
	}

	@Override
	public void deleteCourse(String courseCode) {
		sql = "delete from Course where coursecode = ?";
		jdbcTemplateObject.update(sql,courseCode);
	}
	
	public List<Course> listCourses() {
		sql = "select * from Course";
		List <Course> courses = jdbcTemplateObject.query(sql, 
				new CourseMapper());
		if(courses.isEmpty()){
			return new ArrayList<Course>();
		}
		return courses;
	}

}
