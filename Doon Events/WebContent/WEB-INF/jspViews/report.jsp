<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
</head>
<body>
<center>
<br>
<br>
<table border="5" >
<tr>
<th>Event ID</th><th>Customer Name</th>
</tr>
<c:forEach var="list" items="${list}">
<tr>
<td align="center">${list.eventId}</td>
<td align="center">${list.participantName}</td>

</tr>
</c:forEach>
</table>

<br>
<br>

<a href="index.jsp">Home</a>
</center>
</body>
</html>