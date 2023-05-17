<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"
	import="java.util.ArrayList" session="true" isELIgnored="false" buffer="52kb" autoFlush="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1 style="color: red; text-align: center;">Server Time is ::</h1>
	<h1 style="color: aqua; text-align: center;"><%=new Date()%>
	</h1>
	<h1 style="color: red; text-align: center;">
		ArrayList Size ::
		<%=new ArrayList<Integer>().size()%></h1>

	<h1 style="color: red; text-align: center;">
		session id is ::<%=session%></h1>
		
		
		<h1> Username is :: <%= request.getParameter("username") %></h1>
		<h1>Username using EL :: ${param.username}</h1>
		<h1><%= getServletInfo()%></h1>
		
			<% for(int i=0;i<100000;i++)
	    	   out.println("Mangesh"); %>
	    	   
	    	   <% for(int i=0;i<100000;i++)
	    	   out.println("CHUTIYA"); %>
		

</body>
</html>