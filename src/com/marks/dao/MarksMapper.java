package com.marks.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bean.Marks;

public class MarksMapper implements RowMapper<Marks> {
	
	Marks marks;
	
	@Override
	public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
		marks = new Marks(rs.getString("rollno"), rs.getString("coursecode"), rs.getInt("marks"));
		return marks;
	}

}
