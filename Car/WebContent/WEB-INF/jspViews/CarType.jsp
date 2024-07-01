<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Service</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Register for car service</h2>
		<br />
		<form:form modelAttribute="carServiceObj" method="POST"
			action="${pageContext.request.contextPath}/Register.html">
			<tr>
				<th>Select Car Type:</th>
			</tr>
			<br>
			<tr>
			<td></td>
			<td><form:radiobutton path="CarType" value="Maruti" label="Maruti" /> 
				<form:radiobutton path="CarType" value="Hyundai" label="Hyundai"/></td>
		</tr>
		<br/>
		<input type="submit" value="Submit Query"/>
		<br/>
		<br/>
		<a href="${pageContext.request.contextPath}/index.jsp">
			Home</a> 
			<spring:hasBindErrors name="carServiceObj">
			<h3>All Errors</h3>
			<form:errors path="*"  cssClass="error"/>
	   	</spring:hasBindErrors>
			</form:form>
		
	</center>
</body>
</html>