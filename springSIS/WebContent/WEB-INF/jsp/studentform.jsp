<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Add New Student</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>ID : </td>   
          <td><form:input path="id"  /></td>  
         </tr>    
         <tr>    
          <td>Name :</td>    
          <td><form:input path="name" /></td>  
         </tr>   
         <tr>    
          <td>Surname :</td>    
          <td><form:input path="surname" /></td>  
         </tr>   
         <tr>    
          <td>Grade :</td>    
          <td><form:input path="grade" /></td>  
         </tr>  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>   