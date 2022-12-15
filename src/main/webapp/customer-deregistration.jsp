<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deregister a Customer</title>

<style type="text/css">


</style>

</head>
<body>

<h1>Enter an account number to deregister a customer. </h1>

<h2>

<%String message = (String) request.getAttribute("MESSAGE");
if(message == null) {
	message = "";
}
out.println(message);
%>
</h2>

<form action="customer-dereg-page.jsp" method="post">

		<label> Account Number:</label>
        <input placeholder=" ACCOUNT NUMBER " type="text" name="accountNumber"/> <br>
        
        <button>Submit</button>
</form>

<h3> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h3>

</body>
</html>