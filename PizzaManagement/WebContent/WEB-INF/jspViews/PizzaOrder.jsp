<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Add Pizza Details</h2>
	<form:form action="savePizzaOrder.html" method="POST" modelAttribute="pizzaOrderBean">
		<table>
			<tr>
			<td>Customer Name</td>
			<td><form:input path="customerName"/></td>
			<td><form:errors path="customerName" cssClass="error"/>
			</tr>
			<tr>
			<td>Contact Number</td>
			<td><form:input path="contactNumber"/></td>
			<td><form:errors path="contactNumber" cssClass="error"/>
			</tr>
			<tr>
			<td>Pizza Name</td>
			<td>
			<form:select path="pizzaId">
				<form:option value="" label="--select--"/>
				<form:options items="${pizzaMap}"/>
			</form:select>
			</td>
			</tr>
			<tr>
			<td>Quantity</td>
			<td><form:input path="numberOfPiecesOrdered"/></td>
			<td><form:errors path="numberOfPiecesOrdered" cssClass="error"/>
			</tr>			
		</table>
		<input type="submit" value="ORDER">
		<spring:hasBindErrors name="pizzaOrderBean">
		<h2>All Errors</h2>
			<form:errors path="*" cssClass="error"/>
		</spring:hasBindErrors>
	</form:form>
	</center>
</body>
</html>