<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>     
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>
<body>

<form:form
action="${pageContext.request.contextPath}/displayCustomerRecordsURL.html
" method="GET" modelAttribute="dateRangeBean">
<table>
<tr>
<td>From Date:</td><td><form:input
path="fromDate"/></td>
<td>To Date:</td><td><form:input
path="toDate"/></td>
</tr>
</table><br>
<input type="submit" value="Fetch Details" /><br>
</form:form>





<a href="${pageContext.request.contextPath}/index.jsp">Home</a>

<c:if test="${not empty beanList }">
<table border="2">
<tr>

<th>CustomerId</th><th>CustomerName</th><th>Bill</th><th>Billing
Date</th>
</tr>
<c:forEach var="list" items="${beanList}">
<tr>

<td>${list.customerId}</td><td>${list.customerName}</td><td>${list.
bill}</td><td>${list.billingDate}</td>
</tr>
</c:forEach>
</table>
</c:if>

</body>
</html>