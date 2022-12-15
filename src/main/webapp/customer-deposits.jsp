<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit Page</title>

<style type="text/css">
  label{
  display: block;
  }
  input{
	width: 30%;
	height: 30px;
}
.customer-depo-page{
	margin-right: 30px;
	text-align: center;
}

button{
	background-color: green;
	width: 30%;
	height: 30px;
	margin-top: 20px;
}

span{
color:red;}

span, h1{
color: black;
}

h2 {

color: red; 

}


</style>


</head>
<body>

<h1>Deposit the desired amount below.</h1>

<form action = "customer-depo-page.jsp" method= "post">

<label> Enter Account Number:</label>
<input placeholder="ACCOUNT NUMBER" type="number" name="accountNumber"/> <br>

<label> Enter Amount to be deposited:</label>
<input placeholder="ACCOUNT DEPOSIT" type="number" name="amount"/> <br>

<label> Enter reference:</label>
<input placeholder="REFERENCE" type="text" name="reference"/> <br>


<button>Submit</button>

</form>

<h2>
<%String message = (String) request.getAttribute("Message");
if(message != null){
	out.println(message);
}
%>

</h2>


<h3>

<a href="customer-display.jsp">Go to the Display Page.</a> <br> 

<a href="menu.sp">Back to the Menu.</a> <br>

</h3>



</body>
</html>