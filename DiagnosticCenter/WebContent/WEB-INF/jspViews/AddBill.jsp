<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Bill Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Add Bill Details</h2>
		<form:form modelAttribute="billBean" action="addBillDetails.html">
			<table border="2">
				<tr>
					<td>Patient Name</td>
					<td><form:input path="patientName" /></td>
				</tr>
				<tr>
					<td>Test</td>
					<td><form:radiobuttons path="testId" items="${testMap}"/></td>
				</tr>
				<tr>
					<td>Date of collection</td>
					<td><form:input path="dateOfCollection"/>
				</tr>
				<tr>
					<td>Paid Amount</td>
					<td><form:input path="paidAmount"/>
				</tr>
			</table>
			<br>
			<input type="submit" value="Add" />
		</form:form>
		<br>
	<br>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
	</center>
</body>
</html>