<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="student" class="com.action.Student" scope="session" />

<center>
	<table border='1'>
		<tr>
			<td>SID</td>
			<td><jsp:getProperty name='student' property="id" /></td>
		</tr>
		<tr>
			<td>SNAME</td>
			<td><jsp:getProperty name='student' property="name" /></td>
		</tr>
		<tr>
			<td>SADDRESS</td>
			<td><jsp:getProperty name='student' property="addres" /></td>
		</tr>
		<tr>
			<td>SALARY</td>
			<td><jsp:getProperty name='student' property="salary" /></td>
		</tr>
	</table>
</center>