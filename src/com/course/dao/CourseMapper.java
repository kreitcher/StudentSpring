package com.course.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bean.Course;

public class CourseMapper implements RowMapper<Course>{

	Course course;
	
	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		course = new Course(rs.getInt("id"),rs.getString("coursecode"),rs.getString("coursename"));
		return course;
	}

}
