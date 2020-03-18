<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Attendance</title>
</head>
<body>
	<h1>Show Attendance</h1>
	
	<p>${course.code } - ${course.title }</p>
	
	<table>
		<tr>
			<th></th>
			<c:forEach var="d" items="${dates}">
				<th>${d }</th>
			</c:forEach>
		</tr>
		<c:forEach var="att" items="${attendance}">
			<tr>
				<td>${att.key }</td>
				<c:forEach var="a" items="${att.value}">
					<td>${a }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
	<br>  
   <br><a href="/springSIS/showcourse/${course.id }">Back</a> 
</body>
</html>