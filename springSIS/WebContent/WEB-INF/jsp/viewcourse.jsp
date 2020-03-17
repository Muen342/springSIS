<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Courses</title>
</head>
<body>
<h1>Course List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>ID</th><th>Title</th><th>Code</th><th>Description</th><th>Teacher</th><th>Credits</th><th>Show</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="course" items="${list}">   
   <tr>  
   <td>${course.id}</td>  
   <td>${course.title}</td>
   <td>${course.code}</td> 
   <td>${course.description}</td> 
   <td>${course.teacher}</td> 
   <td>${course.credits}</td> 
   <td><a href="showcourse/${course.id}">Show</a></td> 
   <td><a href="editcourse/${course.id}">Edit</a></td>  
   <td><a href="deletecourse/${course.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="courseform">Add New Course</a> 
   <br><a href="courses.jsp">Back</a> 
 

</body>
</html>