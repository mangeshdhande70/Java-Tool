<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1 style='color:blue; text-align: center'>
	Data Retrieved from Particular Scope :: <%= pageContext.getAttribute("p") %><br/>
	Data Retrieved from Particular Scope :: <%= request.getAttribute("r") %><br/>
	Data Retrieved from Particular Scope :: <%= session.getAttribute("s") %><br/>
	Data Retrieved from Particular Scope :: <%= application.getAttribute("a") %>
 </h1>

</body>
</html>