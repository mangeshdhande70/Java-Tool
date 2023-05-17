<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="cal" class="com.action.App" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
    <h1> Square of 5  is :: <%= cal.sqr(5)%> </h1>
    <h1> Square of 6  is :: <%= cal.sqr(6)%> </h1>
    <h1 style="color:red;"> Message :: <%= cal.hello() %> </h1>
  
</body>
</html>