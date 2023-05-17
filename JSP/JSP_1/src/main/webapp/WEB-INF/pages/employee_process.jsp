<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%!  
        
      Connection connection = null;
      PreparedStatement preparedStatement1 = null;
      PreparedStatement preparedStatement2 = null;
      ResultSet resultSet = null;
      
      public void jspInit(){
    	  
    	  ServletConfig config = getServletConfig();
    	  
    	  String url = config.getInitParameter("url");
    	  String user = config.getInitParameter("username");
    	  String pass = config.getInitParameter("password");
    	  
    	  try{
    		  
    		  Class.forName("com.mysql.cj.jdbc.Driver");
    		  connection = DriverManager.getConnection(url, user, pass);
     preparedStatement1 = connection.prepareStatement("INSERT INTO employee(name,address,salary) VALUES (?,?,?)");
     preparedStatement2 = connection.prepareStatement("SELECT * FROM employee");
    		  
    	  }catch(ClassNotFoundException exception){
    		  exception.printStackTrace();
    	  } catch (SQLException se) {
  			se.printStackTrace();
  		} 
      }%>

<% 
    
      String action = request.getParameter("s1");
    
    if(action.equalsIgnoreCase("register")){
    	
    	preparedStatement1.setString(1, request.getParameter("ename"));
    	preparedStatement1.setString(2, request.getParameter("eaddr"));
    	preparedStatement1.setInt(3,Integer.parseInt(request.getParameter("esal")));
    	
      int r = preparedStatement1.executeUpdate();
    	
      if(r==1){
 %>
<h1 style="color: green;">registered successfully</h1>
<% }else { %>
<h1 style="color: red;">registration failed</h1>
<% } } else{ 
 
      resultSet = preparedStatement2.executeQuery();
      %>
<table bgcolor='pink' align='center' border='1'>
	<tr>
		<th>EID</th>
		<th>ENAME</th>
		<th>EADDR</th>
		<th>ESAL</th>
	</tr>
	<% while(resultSet.next()){
	 %>
	<tr>
		<td><%=resultSet.getInt(1)%></td>
		<td><%=resultSet.getString(2)%></td>
		<td><%=resultSet.getString(3)%></td>
		<td><%=resultSet.getInt(4)%></td>
	</tr>
	<%} %>
	</table>
	<% } %>
	
	<br/> <br/>
	
	<h1 style="text-align:center;"><a href="./index.html">|HOMEPAGE|</a></h1>h1>
	
	<%!public void jspDestroy() {
		System.out.println("Cleaning the environment....");
		try {
			if (preparedStatement1 != null)
				preparedStatement1.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (preparedStatement2 != null)
				preparedStatement2.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (connection != null)
				connection.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}%>
	
	
	