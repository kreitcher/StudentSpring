package com.student.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.Student;

public class StudentDAOImpl implements StudentDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	Student student;
	String sql;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplateObject = new JdbcTemplate(dataSource);		
	}

	@Override
	public void createStudent(String rollNo, String name) {
		createStudent(new Student(rollNo,name));
	}

	@Override
	public void createStudent(Student student) {
		sql = "insert into Student(rollno,name) values (?,?)";
		jdbcTemplateObject.update(sql,student.getRollNo(),student.getName());		
	}

	@Override
	public Student getStudent(String rollNo) {
		sql = "select * from Student where rollno = ?";
		student = jdbcTemplateObject.queryForObject(sql, 
				new Object[]{rollNo}, new StudentMapper());
		return student;
	}

	@Override
	public Student getStudent(int id) {
		sql = "select * from Student where id = ?";
		student = jdbcTemplateObject.queryForObject(sql, 
				new Object[]{id}, new StudentMapper());
		return student;
	}

	@Override
	public void updateStudentName(String rollNo, String name) {
		sql = "update Student set name = ? where rollno = ?";
		jdbcTemplateObject.update(sql, name, rollNo);
	}

	@Override
	public void updateStudentName(int id, String name) {
		sql = "update Student set name = ? where id = ?";
		jdbcTemplateObject.update(sql, name, id);		
	}

	@Override
	public void updateStudentRollNo(int id,String rollNo) {
		sql = "update Student set rollno = ? where id = ?";
		jdbcTemplateObject.update(sql, rollNo, id);
	}

	@Override
	public void updateStudentRollNo(String rollNoOld, String rollNoNew) {
		sql = "update Student set rollno = ? where rollno = ?";
		jdbcTemplateObject.update(sql, rollNoNew, rollNoOld);

	}

	@Override
	public void deleteStudent(int id) {
		sql ="delete from Student where id = ?";
		jdbcTemplateObject.update(sql, id);

	}

	@Override
	public void deleteStudent(String rollNo) {
		sql ="delete from Student where rollno = ?";
		jdbcTemplateObject.update(sql, rollNo);
	}

	public List<Student> listStudents() {
		sql = "select * from Student";
		List <Student> students = jdbcTemplateObject.query(sql, 
				new StudentMapper());
		return students;
	}

}
