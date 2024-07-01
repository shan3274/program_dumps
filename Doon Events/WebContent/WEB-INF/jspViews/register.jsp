<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Registration</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Event Registration</h2>
		
		<form:form action="registerForEvent.htm" modelAttribute="registerBean">
		
			<table>
				<tr>
					<td>Participant Name</td>
					<td><form:input path="participantName"/></td>		
				</tr>
				
				<tr>
					<td>Event Name</td>
					<td>
						<form:select path="eventId">
							<form:option value="" label="--Select--"></form:option>
							<form:options items="${eventList}"/>
						</form:select>
					</td>
				</tr>
				
				<tr>
					<td>Participant Age</td>
					<td><form:input path="age"/></td>
				</tr>
			</table>
			
			<br><br>
			<input type="submit" value="Register"/>
			<br><br>
			<spring:hasBindErrors name="registerBean">
				<font color="red"><form:errors path="*"></form:errors></font>
			</spring:hasBindErrors>
		
			<br>
			${message}
			${errors}
		</form:form>
		
		<br><br>
		<a href="index.jsp">Home</a>
	</center>
</body>
</html>