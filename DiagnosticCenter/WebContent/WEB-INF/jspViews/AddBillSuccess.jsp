<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bill Success</title>
</head>
<body>
	<center>
		<h2>Bill Added Successully!</h2>
		<br>
		<br>
		<h3>${message}</h3>	
		<br>
	<br>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
	</center>
</body>
</html>