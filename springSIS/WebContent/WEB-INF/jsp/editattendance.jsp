<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Attendance</title>
</head>
<body>
	<h1>Edit Attendance</h1>
	
	<c:forEach var="s" items="${student_list}">   
   		<p> ${s} </p>
   </c:forEach>  
</body>
</html>