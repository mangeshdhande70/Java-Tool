<%@ page isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>

	<c:url value="http://google.com/" var="googleUrl" scope="request" />
	
	<c:redirect url="${googleUrl }" />
	
	

</body>
</html>

