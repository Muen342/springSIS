<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Attendance</title>
</head>
<body>
	<h1>Edit Attendance</h1>
	
	<form method="post" action="/springSIS/saveattendance/${course.id }">   
		<c:forEach var="s" items="${students}">
	   		<label for="${s.id }">${s.name }:</label><br>
  			<input type="text" id="${s.id }" name="${s.id }"><br>
  		</c:forEach> 
	   
	   <input type="submit" value="Save" />   
	</form>    
	

   
</body>
</html>