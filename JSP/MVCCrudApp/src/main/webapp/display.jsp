<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <c:choose>
       <c:when test="${student ne null || !empty student }">
       <table border='1'>
       <caption>Student Record</caption>
          <tr>
             <th>ID</th>
             <th>Name</th>
             <th>Age</th>
             <th>Address</th>
          </tr> 
          <tr>
             <td>${student.id }</td> 
             <td>${student.sname }</td> 
             <td>${student.sage }</td> 
             <td>${student.saddress}</td> 
          </tr>        
       </table>
       
       </c:when>
       <c:otherwise>
          <h1 style='color:red; text-algin:center;'> No Record Found</h1> 
        </c:otherwise> 
    </c:choose>

</body>
</html>