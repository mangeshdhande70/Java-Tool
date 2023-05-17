<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
	<%
	int[] arr = {};
	java.util.ArrayList<String> al = new java.util.ArrayList<>();
	%>
	${empty sachin }
	<br /> ${empty "sachin"}
	<br /> ${empty null }
	<br /> ${empty arr }
	<br /> ${empty al }
	<hr />

	${10+""}
	<br /> ${empty null }
	<br /> ${!null}


</body>
</html>

