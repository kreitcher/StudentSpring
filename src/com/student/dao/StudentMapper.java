package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bean.Student;

public class StudentMapper implements RowMapper<Student>{
	
	Student student;
	
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		student = new Student(rs.getInt("id"),rs.getString("rollno"),rs.getString("name"));		
		return student;
	}

}
