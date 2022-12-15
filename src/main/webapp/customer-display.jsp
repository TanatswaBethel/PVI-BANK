<%@page import= "za.co.pviBank.entities.Customer" %>
<%@page import= "za.co.pviBank.entities.Account" %>
<%@page import= "java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Customer's Details</title>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h1> List of Customers </h1>

<form action="customer-dis-page.jsp" method="get">
<button>Get All Details</button>

</form>

<h2>
<%
String message = (String) request.getAttribute("MESSAGE");
if(message == null) {
	message = "";
}
out.println(message);
%>
</h2>

<% List<Customer> customers = (List<Customer>) request.getAttribute("CUSTOMERS");%>

<table>
<tr>
<th>First Name</th>
<th>Surname</th>
<th>Gender</th>
<th>Date Of Birth</th>
<th>Identification Number</th>
<th>Occupation</th>
<th>Email Address</th>
<th>Marital Status</th>
<th>Residential Address</th>
<th>Phone Number</th>
<th> Account ID</th>
<th>Account Number</th>
<th>Account Type</th>
<th>Card Number</th>
<th>Balance</th>
</tr>


<%
if (customers != null){
	for(int a = 0; a < customers.size(); a++) {%>
		
		<tr>
		<td><%out.println(customers.get(a).getFirstName());%></td>
		<td><%out.println(customers.get(a).getSurname());%></td>
		<td><%out.println(customers.get(a).getGender());%></td>
		<td><%out.println(customers.get(a).getDateOfBirth());%></td>
		<td><%out.println(customers.get(a).getIdNumber());%></td>
		<td><%out.println(customers.get(a).getOccupation());%></td>
		<td><%out.println(customers.get(a).getEmailAddress());%></td>
		<td><%out.println(customers.get(a).getMaritalStatus());%></td>
		<td><%out.println(customers.get(a).getResidentialAddress());%></td>
		<td><%out.println(customers.get(a).getPhoneNumber());%></td>
		
		<td><%out.println(customers.get(a).getAccount().getId());%></td>
		<td><%out.println(customers.get(a).getAccount().getAccountNumber());%></td>
		<td><%out.println(customers.get(a).getAccount().getAccountType());%></td>
		<td><%out.println(customers.get(a).getAccount().getCardNumber());%></td>
		<td><%out.println(customers.get(a).getAccount().getAccountBalance());%></td>
		</tr>
	<%}
}%>

</table>


<h3> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h3>
</body>
</html>