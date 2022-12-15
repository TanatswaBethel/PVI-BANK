<%@page import= "za.co.pviBank.entities.Employee" %>
<%@page import= "java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Display Page </title>

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

<h1> List of Employees </h1>

<form action="employee-display-page.jsp" method="get">
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

<% List<Employee> employees = (List<Employee>) request.getAttribute("EMPLOYEES");%>

<table>

<tr>
<th>ID</th>
<th>Staff Number</th>
<th>First Name</th>
<th>Surname</th>
<th>Gender</th>
<th>Date Of Birth</th>
<th>Identification Number</th>
<th>Position</th>
<th>Email Address</th>
<th>Marital Status</th>
<th>Residential Address</th>
<th>Phone Number</th>
<th>User Name</th>
<th>Password</th>
</tr>

<%
if (employees != null){
	for(int a = 0; a < employees.size(); a++) {%>
		
		<tr>
		<td><%out.println(employees.get(a).getId());%></td>
		<td><%out.println(employees.get(a).getStaffNumber());%></td>
		<td><%out.println(employees.get(a).getFirstName());%></td>
		<td><%out.println(employees.get(a).getSurname());%></td>
		<td><%out.println(employees.get(a).getGender());%></td>
		<td><%out.println(employees.get(a).getDateOfBirth());%></td>
		<td><%out.println(employees.get(a).getId());%></td>
		<td><%out.println(employees.get(a).getPosition());%></td>
		<td><%out.println(employees.get(a).getEmailAddress());%></td>
		<td><%out.println(employees.get(a).getMaritalStatus());%></td>
		<td><%out.println(employees.get(a).getResidentialAddress());%></td>
		<td><%out.println(employees.get(a).getPhoneNumber());%></td>
		<td><%out.println(employees.get(a).getUserName());%></td>
		<td><%out.println(employees.get(a).getPassword());%></td>
		</tr>
	<%}
}%>




</table>


<h3> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h3>

</body>
</html>