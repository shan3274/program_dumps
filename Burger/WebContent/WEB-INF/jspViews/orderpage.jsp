<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h2>Order Burger</h2>
		<br>
		<form:form modelAttribute="burgerBean" method="POST"
		action="${pageContext.request.contextPath}/OrderBurger.html">
		
		<table>
		<tr>
		  <td>Burger Name</td>
		  <td>
		      <form:select path="burgerName">
		        <form:option label="--Select--" value=""/>
		        <form:options items="${burgerList}"/>
		      </form:select>
		  </td>
		 </tr>
		 <tr>
		  <td>Topping Name</td>
		  <td>
		      <form:select path="toppingName">
		        <form:option label="--Select--" value=""/>
		        <form:options items="${toppingList}"/>
		      </form:select>
		  </td>
		 </tr>
		 <tr>
		  <td>Number of Burgers</td>
		  <td>
		      <form:input path="noOfBurgers"/>
		  </td>
		 </tr>
		</table>
		<input type="submit" value="Order">
		<spring:hasBindErrors name="burgerOrderObj">
		   <form:errors path="*" cssClass="error"/>
		</spring:hasBindErrors>
        </form:form>
	</center>
</body>
</html>