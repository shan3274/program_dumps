<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background: lavender;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2><u>Compliant Report Details</u></h2>
<form:form action="getDetails.html" method="POST" modelAttribute="dateRangeBean">
<table>
<tr>
<td>From Date <div style="color: blue">[dd-MMM-yyyy]</div></td>
<td><form:input path="fromDate"/>
</tr>
<tr>
<td>To Date <div style="color: blue">[dd-MMM-yyyy]</div></td>
<td><form:input path="toDate"/>
</tr>
</table><br>
<input type="submit" value="Fetch" >
</form:form>
<br><br><a href="${pageContext.request.contextPath}/index.jsp">HOME</a>
</center>
</body>
</html>