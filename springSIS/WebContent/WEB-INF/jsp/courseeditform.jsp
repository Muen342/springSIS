<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
</head>
<body>
	<h1>Edit Course</h1>  
       <form:form method="POST" action="/springSIS/editsavecourse">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Title : </td>   
          <td><form:input path="title"  /></td>  
         </tr>    
         <tr>    
          <td>Description : </td>   
          <td><form:input path="description"  /></td>  
         </tr>  
         <tr>    
          <td>Teacher : </td>   
          <td><form:input path="teacher"  /></td>  
         </tr>  
         <tr>    
          <td>Credits : </td>   
          <td><form:input path="credits"  /></td>  
         </tr>  
         <tr>    
          <td>Code : </td>   
          <td><form:input path="code"  /></td>  
         </tr> 
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>   
       
       <br><br><a href="/springSIS/viewcourse">Back</a>  

</body>
</html>