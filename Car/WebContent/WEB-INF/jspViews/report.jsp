<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dummy Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Car Service Report</h2>
		<br />
	
				
				<table border="2">
				<tr>
					<th>Car Type</th><th>Car number</th><th>username</th><th>total repair cost</th>
				</tr>
				
				<c:forEach items="${orderList}" var="itr">
				<tr>
					<td><c:out value="${itr.carType}"/> </td>
					<td><c:out value="${itr.carNumber}"/> </td>
					<td><c:out value="${itr.userName}"/></td>
					<td><c:out value="${itr.totalRepairCost}"/></td>
				</tr>
				</c:forEach>
				
			</table>
			

			
			<a href="${pageContext.request.contextPath}/index.jsp">
			Home</a>
		
	</center>
</body>
</html>