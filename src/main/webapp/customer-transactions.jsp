<%@page import= "za.co.pviBank.entities.Account" %>
<%@page import= "za.co.pviBank.entities.Transactions" %>

<%@page import= "java.util.List" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Bank Statements</title>

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

<h1> Record of Transactions </h1>

<form action="customer-trans.jsp" method="post">

		<label> Account Number:</label>
        <input placeholder=" ACCOUNT NUMBER " type="number" name="accountNumber"/> <br>
        <button>Submit</button>
        
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

<h2> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h2>



</body>
</html>