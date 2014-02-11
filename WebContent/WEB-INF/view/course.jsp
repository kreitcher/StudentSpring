<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.bean.Course" %>
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
						<h3>Course Operations.</h3>
					</td>
				</tr>
				<tr>
					<td>
						<form action="courseAdd" method="post">
							<table>
								<tr>
									<td colspan="3">Add a Course.</td>
								</tr>
								<tr>
									<td>Course Code :&nbsp;<input type="text" name="coursecode"/>
									</td>
									<td>Course Name :&nbsp;<input type="text" name="coursename"/>
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
						<form action="courseSearch">
							<table>
								<tr>
									<td colspan="2">Search courses.</td>
								</tr>
								<tr>
									<td>Course Code :&nbsp;<input type="text" name="coursecode" />
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
						<form action="courseAll">
							<table>
								<tr>
									<td colspan="2">List all Courses.</td>
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
					<td colspan="2">The following record(s) have been added.</td>
				</tr>
				<tr>
					<td><h5>Course Code</h5></td>
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
						<form action="course">
							<input type="submit" value="&lt;&lt; Back to Course Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:when test="${ops == 'search'}">
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
						<form action="course">
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
				<c:forEach var="course" items="${courseList}">
					<tr>
						<td>${course.courseCode}</td>
						<td>${course.courseName}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<form action="course">
							<input type="submit" value="&lt;&lt; Back to Course Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
	</c:choose>
</body>
</html>