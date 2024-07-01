<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Page</title>
</head>
<body>
<center>
<h2>Order within Price Range Report</h2>
<form:form action="fetchOrder.html" method="POST" modelAttribute="billRangeBean">
	<table border="2">
		<tr>
		<td>From Price:</td>
		<td><form:input path="fromBill"/></td>
		<td>To Price:</td>
		<td><form:input path="toBill"/></td>
		</tr>
	</table>
	<input type="submit" value="Fetch Details">
</form:form>
<c:if test="${not empty pizzaList}">
	<table border="2">
		<tr>
			<th>Order Id</th><th>Customer Name</th><th>Pizza Id</th><th>Bill</th><th>Quantity</th>
		</tr>
		<c:forEach var="pizzaOrder" items="${pizzaList}">
			<tr>
			<td>${pizzaOrder.orderId}</td>
			<td>${pizzaOrder.customerName}</td>
			<td>${pizzaOrder.pizzaId}</td>
			<td>${pizzaOrder.bill}</td>
			<td>${pizzaOrder.numberOfPiecesOrdered}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<%-- <c:if test="${empty pizzaList }">
	<h2>No Orders Found</h2>
</c:if> --%>
<br>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
</center>
</body>
</html>