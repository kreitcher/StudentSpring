package com.app.dispatcher;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Course;
import com.bean.Marks;
import com.bean.Student;
import com.course.service.CourseService;
import com.marks.service.MarksService;
import com.student.service.StudentService;



@Controller
public class StudentDispatcher {
	StudentService studentService;
	CourseService courseService;
	MarksService marksService;

	List<Student> studentList;
	List<Course> courseList;
	List<Marks> marksList;

	public StudentDispatcher(){
		studentService = new StudentService();
		courseService = new CourseService();
		marksService = new MarksService();
	}

	@RequestMapping("/")
	public String root() {
		return "index";
	}

	/* Index page links*/
	@RequestMapping("/student")
	public String studentHandler(Model model){
		model.addAttribute("ops", "");
		return "student";
	}

	@RequestMapping("/course")
	public String courseHandler(Model model){
		model.addAttribute("ops","");
		return "course";
	}

	@RequestMapping("/marks")
	public String marksHandler(Model model){
		return "marks";
	}

	/* Student operations */
	
	@RequestMapping(value = "/studentAdd", method = RequestMethod.POST)
	public String studentAddHandler(@RequestParam("name") String name,@RequestParam("rollno") String rollNo,Model model){
		studentList = studentService.addRecord(rollNo, name);
		model.addAttribute("studentList", studentList);
		model.addAttribute("ops", "add");
		return "student";
	}

	@RequestMapping(value = "/studentSearch", method = RequestMethod.GET)
	public String studentSearchHandler(@RequestParam("rollno") String rollNo,Model model){
		studentList = studentService.searchRecords(rollNo);
		model.addAttribute("studentList", studentList);
		model.addAttribute("ops", "search");
		return "student";
	}

	@RequestMapping("/studentAll")
	public String studentListHandler(Model model){
		studentList = studentService.listRecords();
		model.addAttribute("studentList", studentList);
		model.addAttribute("ops", "list");
		return "student";
	}

	/*course operations*/
	
	@RequestMapping(value = "/courseAdd", method = RequestMethod.POST)
	public String courseAddHandler(@RequestParam("coursecode") String courseCode, @RequestParam("coursename") String courseName, Model model){

		courseList = courseService.addCourse(new Course(courseCode,courseName));
		model.addAttribute("ops", "add");
		model.addAttribute("courseList", courseList);
		return "course";
	}

	@RequestMapping(value = "/courseSearch",method = RequestMethod.GET)
	public String courseSearchHandler(@RequestParam("coursecode") String courseCode, Model model){
		courseList = courseService.searchCourse(courseCode);
		model.addAttribute("ops", "search");
		model.addAttribute("courseList", courseList);
		return "course";
	}

	@RequestMapping("/courseAll")
	public String courseSearchHandler(Model model){
		courseList = courseService.listCourse();
		model.addAttribute("ops", "list");
		model.addAttribute("courseList", courseList);
		return "course";
	}
	
	/*Marks operations*/
	
	@RequestMapping(value="/marksAdd", method = RequestMethod.POST)
	public String marksAddHandler(@RequestParam("rollno") String rollNo, @RequestParam("coursecode") String courseCode, @RequestParam("marks") String marks,Model model){
		marksList = marksService.addRecord(new Marks(rollNo, courseCode, Integer.valueOf(marks)));
		model.addAttribute("ops", "add");
		model.addAttribute("marksList", marksList);
		return "marks";
	}
	
	@RequestMapping(value="/marksSearchStudents",method = RequestMethod.GET)
	public String marksSearchStudent(@RequestParam("coursecode") String courseCode, Model model){
		studentList = marksService.getStudentList(courseCode);
		model.addAttribute("ops", "searchStudents");
		model.addAttribute("studentList", studentList);
		return "marks";
	}
	
	@RequestMapping(value = "/marksSearchCourses", method = RequestMethod.GET)
	public String marksSearchCourses(@RequestParam("rollno") String rollNo, Model model){
		courseList = marksService.getCourseList(rollNo);
		model.addAttribute("ops", "searchCourses");
		model.addAttribute("courseList", courseList);
		return "marks";
	}
	
	@RequestMapping("/marksAll")
	public String marksAllRecords(Model model){
		marksList = marksService.getAllRecords();
		model.addAttribute("ops", "add");
		model.addAttribute("marksList", marksList);
		return "marks";
	}
}
