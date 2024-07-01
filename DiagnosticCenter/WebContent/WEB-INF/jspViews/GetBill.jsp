<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Bill Details</title>
</head>
<body>
<center>
<h2>Get Bill Details Within Date Range</h2>
	<form:form action="getBillDetails.html" modelAttribute="dateRangeBean">
		<table border="2">
			<tr>
				<td>From date</td>
				<td><form:input path="from"/></td>
			</tr>
			<tr>
				<td>To date</td>
				<td><form:input path="to"/></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Fetch Details"/>
	</form:form>
	<br>
	<c:if test="${empty billList}">
		<h3>No Bills in the given date range!!!</h3>
	</c:if>
	<c:if test="${not empty billList}">
	<table border="2">
			<tr>
				<td>Bill No</td>
				<td>Patient Name</td>
				<td>Test Id</td>
				<td>Date of Collection</td>
				<td>Paid Amount</td>
				<!-- <td>Test Name</td>
				<td>Balance Amount</td> -->
			</tr>
			<c:forEach var="bill" items="${billList}">
			
				<tr>
					<td>${bill.billNo}</td>
					<td>${bill.patientName}</td>
					<td>${bill.testId}</td>
					<td>${bill.dateOfCollection}</td>
					<td>${bill.paidAmount}</td>
					<!-- <td>${bill.testName}</td> -->
					<!-- <td>${bill.balanceAmount}</td> -->
				</tr>
			
			</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</center>
</body>
</html>