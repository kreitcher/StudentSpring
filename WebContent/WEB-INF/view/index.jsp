<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student App</title>
</head>
<body>
	<table>
		<tr>
		<td colspan="3">
		Please click one of the buttons to begin operations...
		</td>
		</tr>
		<tr>
			<td>
				<form action="student">
					<input type="submit" value="Student Operations">
				</form>
			</td>
			<td>
				<form action="course">
					<input type="submit" value="Course Operations">
				</form>
			</td>
			<td>
				<form action="marks">
					<input type="submit" value="Marks Operations">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>