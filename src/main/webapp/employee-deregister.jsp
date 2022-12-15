<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deregister Employee</title>

<style type="text/css">



span, h2 {
color: red;
}

</style>

</head>
<body>

<h1>Enter a staff number to deregister an employee. </h1>

<h2>

<%String message = (String) request.getAttribute("MESSAGE");
if(message == null) {
	message = "";
}
out.println(message);
%>
</h2>

<form action="dereg-employee-page.jsp" method="post">

		<label> Staff Number:</label>
        <input placeholder=" STAFF NUMBER " type="text" name="staffNumber"/> <br>
        
        <button>Submit</button>
</form>

<h3> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h3>

</body>
</html>