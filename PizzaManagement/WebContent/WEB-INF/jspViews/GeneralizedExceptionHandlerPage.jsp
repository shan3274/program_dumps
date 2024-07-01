<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<center>
	<h2 style='color:red'>Generalized Exception Handler Page</h2>
	<br>
	<b>${exception}</b><br>
	<b>${message}</b><br>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</center>
</body>
</html>