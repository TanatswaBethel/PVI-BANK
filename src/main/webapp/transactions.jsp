<%@page import= "za.co.pviBank.entities.Account" %>
<%@page import= "za.co.pviBank.entities.Transactions" %>

<%@page import= "java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions</title>
</head>

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

<body>


<% List<Transactions> transactions = (List<Transactions>) request.getAttribute("TRANSACTIONS");%>


<h2> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h2>

<table>

<tr>
<th>ID</th>
<th>Account Number</th>
<th>Amount</th>
<th>Reference</th>
<th>Transaction Date</th>
<th>Account Balance</th>
</tr>


<%
if (transactions != null){
	for(int a = 0; a < transactions.size(); a++) {%>
		
		<tr>
		<td><%out.println(transactions.get(a).getId());%></td>
		<td><%out.println(transactions.get(a).getAccountNumber());%></td>
		<td><%out.println(transactions.get(a).getAmount());%></td>
		<td><%out.println(transactions.get(a).getReference());%></td>
		<td><%out.println(transactions.get(a).getTransactionDate());%></td>
		<td><%out.println(transactions.get(a).getAccountBalance());%></td>
		</tr>
	<%}
}%>

</table>


<h2> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h2>


</body>
</html>