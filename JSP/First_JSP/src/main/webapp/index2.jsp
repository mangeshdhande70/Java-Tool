
<%@ page language ="java" isELIgnored='false'  %>
<h1>Working with Implicit object(9)...</h1>
<h1>
	The context parameter UserName is ::
	<%=application.getInitParameter("username")%><br/><br/>
	The application name is :: <%= application.getServletContextName()%> </h1>
	
	<br/>
	
	<h1>
	
	Session Id is:: <%= session.getId() %><br/>
	Session is newly created :: <%= session.isNew() %><br/>
	Session Time out is :: <%= session.getMaxInactiveInterval() %> seconds<br/>
	
	</h1>
	<%@include file='second.jsp' %>
	





