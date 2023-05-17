<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Page</title>
</head>
<body>



		<c:choose>
			<c:when test="${accountList ne null || !empty accountList}">
				<table align="center" border="1">

					<tr>
						<th>Account No</th>
						<th>Name</th>
						<th>Balance</th>
						<th>Account Type</th>
						<th>Account Status</th>
						<th>Branch Name</th>
						<th>IFSC CODE</th>

					</tr>
					<c:forEach var="dto" items="${accountList}">
						<tr>
							<td>${dto.accountNo}</td>
							<td>${dto.name}</td>
							<td>${dto.balance}</td>
							<td>${dto.accountType}</td>
							<td>${dto.accountStatus}</td>
							<td>${dto.branchName}</td>
							<td>${dto.ifscCode}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
		
		<c:if test="${pageNo>1 }">
		<b>
		<a href='./get?pageNo=${pageNo-1}&s1=link'>Previous</a>&nbsp;&nbsp;
		</b>
		
		</c:if>
		
		<c:forEach var='i' begin='1' end='${pageCount}' step="1">
		  <b>
		    <a href='./get?pageNo=${i}&s1=link'>[${i}]</a>
		  </b>
		</c:forEach>
		
		
		<c:if test="${pageNo<pageCount}">
		<b>
		<a href='./get?pageNo=${pageNo+1}&s1=link'>Next</a>&nbsp;&nbsp;
		</b>
		
		</c:if>
</body>
</html>