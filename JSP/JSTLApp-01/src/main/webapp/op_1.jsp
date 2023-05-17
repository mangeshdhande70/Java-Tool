<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
	<h1 style='color:blue; text-align: center;'>
	
	+ Operator <br/>
	
	 ("" + 3) ==>  :: ${""+3} <br/>
	 (abc+ 3) ==>  :: ${""+3}<br/>
	 <c:catch>
	 ("abc"+3)==>  :: ${"abc"+3}<br/>
	  </c:catch>
	 <br/>
	 (3+3)    ==>  :: ${3+3} <br/>
	</h1>
	
	
	
	<h1 style='color:blue; text-align: center;'>
	- Operator <br/>
	
	 ("" - 3) ==>  :: ${""-3} <br/>
	 (abc- 3) ==>  :: ${""-3}<br/>
	 <c:catch>
	 ("abc"-3)==>  :: ${"abc"-3}<br/>
	  </c:catch>
	 <br/>
	 (3-3)    ==>  :: ${3-3} <br/>
	</h1>
	
	<h1 style='color:blue; text-align: center;'>
	/ Operator <br/>
	
	 (10/2) ==>  :: ${10/2} <br/>
	 (10 div 2) ==>  :: ${10 div 2}<br/>
	 <c:catch>
	 (10/0)==>  :: ${10/0}<br/>
	  </c:catch>
	 <br/>
	 (0/0)    ==>  :: ${0/0} <br/>
	</h1>
	
	
	
</body>
</html>

