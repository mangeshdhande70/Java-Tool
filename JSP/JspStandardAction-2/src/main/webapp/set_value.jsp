<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="student" class="com.action.Student" scope="session"/>    

<h1>Setting Value</h1>

<jsp:setProperty name="student" property="id" value="123" />
<jsp:setProperty name="student" property="name" value="Ankit" />
<jsp:setProperty name="student" property="addres" value="Gadchiroli" />
<jsp:setProperty name="student" property="salary" value="1000000" />


<%= student %>

<br/>

<%--setting the request parameter values to student bean--%>
<jsp:setProperty name='student' property="id" param="id"/>
<jsp:setProperty name='student' property="name" param="name"/>
<jsp:setProperty name='student' property="addres" param="addres"/>
<jsp:setProperty name='student' property="salary" param="sala"/>
<h1 style='color:red; text-align:center;'><%= student %></h1><br/><br/>

<%--if java bean properties and request parameter names are same then map property with '*'--%>
	<jsp:setProperty name='student' property="*"/>
<h1 style='color:green; text-align:center;'><%= student %></h1>