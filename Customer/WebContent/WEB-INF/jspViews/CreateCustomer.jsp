<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Customer Creation</title> 
</head> 
<body> 


<h2>Add Customer Details</h2> 

<form:form action="${pageContext.request.contextPath}/saveCustomer.html" method="POST" modelAttribute="customerBean"> 

 <table border="2"> 

 <tr> 

 <td>Customer Name</td> 

 <td><form:input path="customerName"/></td> 

 </tr> 

 <tr> 

 <td>Customer Type</td> 

 <td><form:radiobuttons path="customerType" items="${customerTypesRadio}"/></td> 

 </tr> 

 <tr> 

 <td>Bill Amount</td> 

 <td><form:input path="bill"/></td> 

 </tr> 

 <tr> 

 <td>Billing Date[dd-MMM-yyyy]</td> 

 <td><form:input path="billingDate"/></td> 

 </tr> 

 </table> 

 <input type="submit" value="Register" /><br><br> 

</form:form> 

<a href="${pageContext.request.contextPath}/index.jsp">Home</a> 


</body> 

</html>

