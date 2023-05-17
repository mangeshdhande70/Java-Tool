<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>

    <c:set var="x" value="10" scope="page" />
	<c:if test="${x>5}">
	   <h1>${x} is greater than 5</h1>
	</c:if>
	
	<hr/>
	
	
	<c:choose>
	
	   <c:when test="${param.p<0}">
	      <h1>${param.p} is a negative number</h1>
	   </c:when>
	   <c:when test="${param.p>0}">
	      <h1>${param.p} is a positive number</h1>
	   </c:when>
	   <c:otherwise>
	      <h1>${p} is a zero </h1>
	  </c:otherwise>
	  </c:choose> 
	
	
	
	
	
</body>
</html>

