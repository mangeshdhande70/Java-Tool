<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <h1>Start Jsp </h1> 
  <b>Start of JSP</b>
	<%
		float salary = 300.0f+(300.0f * 3);
	%>
   
    <!-- param data are stored in request object -->
   <jsp:forward page="sec.jsp">
        <jsp:param value="divya" name="name"/>  
		<jsp:param value="<%=salary%>" name="salary"/>
   </jsp:forward>
   
   <h1>Content of Page</h1>
   
 

</body>
</html>