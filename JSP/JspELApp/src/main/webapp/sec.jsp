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
    Data Retrieved from Particular Scope :: ${p}<br/>   <!-- pageContext.getAttribute("p") -->
	Data Retrieved from Particular Scope :: ${requestScope.r}<br/>  <!-- pageContext.getAttribute("r",2) -->
	Data Retrieved from Particular Scope :: ${sessionScope.s}<br/>   <!-- pageContext.getAttribute("s",3) -->
	Data Retrieved from Particular Scope :: ${applicationScope.a }<br/>   <!-- pageContext.getAttribute("a",4) -->
	
 </h1>
 
  <h1 style='color:red; text-align: center'>
	Data Retrieved from Particular Scope :: ${request.method}<br/>  <!-- pageContext.getAttribute("r",2) -->
	Data Retrieved from Particular Scope :: ${session.id}<br/>   <!-- pageContext.getAttribute("s",3) -->
 </h1>
 
 
   <h1 style='color:green; text-align: center'>
    Data Retrieved from Particular Scope using pageContext :: ${pageContext.request.method}<br/>  <!-- pageContext.getAttribute("r",2) -->
	Data Retrieved from Particular Scope using pageContext  :: ${pageContext.session.id}<br/>   <!-- pageContext.getAttribute("s",3) -->
	
 </h1>
    
    <h1>UserName is :: ${initParam.user}</h1>   <!-- initParam ===> context.getInitParameter('key') -->
    <h1>Password is :: ${initParam.password}</h1>
    <h1>URL is :: ${initParaam.url}</h1>
    
</body>
</html>