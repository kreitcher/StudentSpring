<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Operations</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty ops}">
			<!-- When the page is displayed in the default mode -->
			<table>
				<tr>
					<td>
						<h3>Marks Operations.</h3>
					</td>
				</tr>
				<tr>
					<td>
						<form action="marksAdd" method="post">
							<table>
								<tr>
									<td colspan="3">Add a Marks record.</td>
								</tr>
								<tr>
									<td>Roll No. :&nbsp;<input type="text" name="rollno" />
									</td>
									<td>Course Code :&nbsp;<input type="text"
										name="coursecode" />
									</td>
									<td>Marks :&nbsp;<input type="text" name="marks" />
									</td>
									<td><input type="submit" value="Add" /></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
				<tr>
					<td>--------------------------------------------------------</td>
				</tr>
				<tr>
					<td>
						<form action="marksSearchStudents">
							<table>
								<tr>
									<td colspan="2">Search Students taking this course.</td>
								</tr>
								<tr>
									<td>Course Code :&nbsp;<input type="text"
										name="coursecode" />
									</td>
									<td><input type="submit" value="search" /></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
				<tr>
					<td>--------------------------------------------------------</td>
				</tr>
				<tr>
					<td>
						<form action="marksSearchCourses">
							<table>
								<tr>
									<td colspan="2">Search Courses this student is taking.</td>
								</tr>
								<tr>
									<td>Roll No. :&nbsp;<input type="text"
										name="rollno" />
									</td>
									<td><input type="submit" value="search" /></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
				<tr>
					<td>--------------------------------------------------------</td>
				</tr>
				<tr>
					<td>
						<form action="marksAll">
							<table>
								<tr>
									<td colspan="2">List all Records.</td>
								</tr>
								<tr>
									<td><input type="submit" value="List all records" /></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
				<tr>
					<td>--------------------------------------------------------</td>
				</tr>
				<tr>
					<td>
						<form action="/StudentSpring">
							<input type="submit" value="&lt;&lt; Back to Index" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:when test="${ops == 'add'}">
			<table>
				<tr>
					<td colspan="3">The following record(s) have been added.</td>
				</tr>
				<tr>
					<td><h5>Roll No</h5></td>
					<td><h5>Course Code</h5></td>
					<td><h5>Marks</h5></td>
				</tr>
				<c:forEach var="marks" items="${marksList}">
					<tr>
						<td>${marks.rollNo}</td>
						<td>${marks.courseCode}</td>
						<td>${marks.marks}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<form action="marks">
							<input type="submit" value="&lt;&lt; Back to Course Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:when test="${ops == 'searchCourses'}">
			<table>
				<tr>
					<td colspan="2">The following course(s) have been found.</td>
				</tr>
				<tr>
					<td><h5>Course Code.</h5></td>
					<td><h5>Course Name</h5></td>
				</tr>
				<c:forEach var="course" items="${courseList}">
					<tr>
						<td>${course.courseCode}</td>
						<td>${course.courseName}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<form action="marks">
							<input type="submit" value="&lt;&lt; Back to Course Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:when test="${ops == 'searchStudents'}">
			<table>
				<tr>
					<td colspan="2">The following Students(s) have been found.</td>
				</tr>
				<tr>
					<td><h5>Roll No.</h5></td>
					<td><h5>Student Name</h5></td>
				</tr>
				<c:forEach var="student" items="${studentList}">
					<tr>
						<td>${student.rollNo}</td>
						<td>${student.name}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<form action="marks">
							<input type="submit" value="&lt;&lt; Back to Course Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:when test="${ops == 'list'}">
			<table>
				<tr>
					<td colspan="2">The following courses(s) are in the Database.</td>
				</tr>
				<tr>
					<td><h5>Course code.</h5></td>
					<td><h5>Course Name</h5></td>
				</tr>
				<c:forEach var="marks" items="${marksList}">
					<tr>
						<td>${marks.rollNo}</td>
						<td>${marks.courseCode}</td>
						<td>${marks.marks}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<form action="marks">
							<input type="submit" value="&lt;&lt; Back to Course Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
	</c:choose>
</body>
</html>