<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <h1>  Name ::  <%= request.getParameter("name") %> </h1>
 <h1> Salary ::  <%= request.getParameter("salary") %> </h1>
    
   <h1 style="color:red;">Address Footer</h1>
   
   <form action="./test" method="get">
      
      <button>GET DATA</button>
   
   </form>

</body>
</html>