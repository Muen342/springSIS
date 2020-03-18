<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Course</title>
</head>
<body>
<h1>Show Course</h1>  

	<p>Title: ${course.title}</p>
	<p>Code: ${course.code}</p>
	<p>Description: ${course.description}</p>
	<p>Credits: ${course.credits}</p>
	<p>Teacher: ${course.teacher}</p>
	
	<br><a href="/springSIS/editattendance/${course.id}">Edit Attendance</a>
	<br><a href="/springSIS/showattendance/${course.id}">Show Attendance</a>
   <br>  
   <br><a href="/springSIS/viewcourse">Back</a> 
 

</body>
</html>