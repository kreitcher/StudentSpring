package com.marks.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bean.Course;
import com.bean.Marks;
import com.bean.Student;
import com.course.dao.CourseMapper;
import com.student.dao.StudentMapper;

public class MarksDAOImpl implements MarksDAO{
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplateObject;
	NamedParameterJdbcTemplate namedParameterJdbcTemplateObject;
	String sql;
	Marks marks;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void createMarksEntry(String rollNo, String courseCode, int marks) {
		createMarksEntry(new Marks(rollNo, courseCode, marks));		
	}

	@Override
	public void createMarksEntry(Marks marks) {
		sql = "insert into Marks(rollno,coursecode,marks) values(?,?,?)";
		jdbcTemplateObject.update(sql,marks.getRollNo(),marks.getCourseCode(),marks.getMarks());
		
	}

	@Override
	public List<Course> getCourseList(String rollNo) {
		List<Course> courseList;
		List<Marks> marksList;
		sql = "select * from `Marks` where `rollno` = ?";
		marksList = jdbcTemplateObject.query(sql, new Object[]{rollNo}, new MarksMapper());
		courseList = getCourseList(marksList);
		return courseList;
	}

	private List<Course> getCourseList(List<Marks> marksList) {
		List<Course> courseList;
		Set<String> courseCodes = new HashSet<String>();
		for(Marks marks : marksList){
			courseCodes.add(marks.getCourseCode());
		}
		sql = "select * from Course where coursecode in ( :coursecodes )";
		namedParameterJdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
		courseList = namedParameterJdbcTemplateObject.query(sql, Collections.singletonMap("coursecodes", courseCodes), new CourseMapper());
		return courseList;
	}

	@Override
	public List<Student> getStudentList(String courseCode) {
		List<Student> studentList;
		List<Marks> marksList;
		sql = "select * from `Marks` where `coursecode` = ?";
		marksList = jdbcTemplateObject.query(sql, new Object[]{courseCode}, new MarksMapper());
		studentList = getStudentList(marksList);
		return studentList;
	}

	private List<Student> getStudentList(List<Marks> marksList) {
		List<Student> studentList;
		Set<String> rollNos = new HashSet<String>();
		for(Marks marks:marksList){
			rollNos.add(marks.getRollNo());
		}
		sql = "select * from Student where rollno in ( :rollnos )";
		namedParameterJdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
		studentList = namedParameterJdbcTemplateObject.query(sql, Collections.singletonMap("rollnos", rollNos),new StudentMapper());
		return studentList;
	}

	@Override
	public void updateMarks(String rollNo, String courseCode, int marks) {
		sql = "update Marks set marks = ? where rollno = ? and coursecode = ?";
		jdbcTemplateObject.update(sql,marks,rollNo,courseCode);
	}

	@Override
	public void deleteCourseEntries(String courseCode) {
		sql = "delete * from marks where coursecode = ?";
		jdbcTemplateObject.update(sql,courseCode);
		
	}

	@Override
	public void deleteStudentEntries(String rollNo) {
		sql = "delete * from marks where rollno = ?";
		jdbcTemplateObject.update(sql,rollNo);
	}

	@Override
	public void deleteEntry(String rollNo, String courseCode) {
		deleteEntry(new Marks(rollNo,courseCode,-1));
	}

	@Override
	public void deleteEntry(Marks marks) {
		sql = "delete * from marks where rollno = ? and coursecode = ?";
		jdbcTemplateObject.update(sql, marks.getRollNo(), marks.getCourseCode());		
	}
	
	public Marks getRecord(String rollNo, String courseCode){
		sql = "select * from Marks where rollno = ? and coursecode = ?";
		marks = jdbcTemplateObject.queryForObject(sql, new Object[]{rollNo,courseCode}, new MarksMapper());
		return marks;
	}

	public List<Marks> listRecords() {
		sql = "select * from Marks";
		List<Marks> marksList = jdbcTemplateObject.query(sql, 
				new MarksMapper());
		return marksList;
	}
}
