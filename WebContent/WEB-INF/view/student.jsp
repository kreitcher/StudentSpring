<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.bean.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Operations</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty ops}">
			<!-- When the page is displayed in the default mode -->
			<table>
				<tr>
					<td>
						<h3>Student Operations.</h3>
					</td>
				</tr>
				<tr>
					<td>
						<form action="studentAdd" method="post">
							<table>
								<tr>
									<td colspan="3">Add a student record.</td>
								</tr>
								<tr>
									<td>Roll No :&nbsp;<input type="text" name="rollno" value=""/>
									</td>
									<td>Name :&nbsp;<input type="text" name="name" value=""/>
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
						<form action="studentSearch">
							<table>
								<tr>
									<td colspan="2">Search records.</td>
								</tr>
								<tr>
									<td>Roll No :&nbsp;<input type="text" name="rollno" />
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
						<form action="studentAll">
							<table>
								<tr>
									<td colspan="2">List all records.</td>
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
						<form action="student">
							<input type="submit" value="&lt;&lt; Back to Student Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:when test="${ops == 'search'}">
			<table>
				<tr>
					<td colspan="2">The following record(s) have been found.</td>
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
						<form action="student">
							<input type="submit" value="&lt;&lt; Back to Student Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:when test="${ops == 'list'}">
			<table>
				<tr>
					<td colspan="2">The following record(s) are in the Database.</td>
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
						<form action="student">
							<input type="submit" value="&lt;&lt; Back to Student Operations" />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
	</c:choose>
</body>
</html>