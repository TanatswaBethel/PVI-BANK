<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
   <style type="text/css">
  label{
  display: block;
  }
  input{
	width: 30%;
	height: 30px;
}
.loginForm{
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

span, h2 {
color: red;
}

span, h3 {
color: black;
}


  </style>
</head>
<body>

<h1>Welcome to PVI BANK</h1>



<h2>
<%String message = (String) request.getAttribute("MESSAGE");
if(message == null) {
	message = "";
}
out.println(message);
%>
</h2>



 <div class="loginForm">
 	<form action="login.jsp" method="post">
        <label> User Name:<span> * </span> </label>
        <input placeholder="USER NAME" type="text" name="userName" required/> <br>

        <label>Password:<span> * </span></label>
        <input placeholder="PASSWORD"  type="password" name="password" required/> <br>

        <button>Submit</button>
</form>
</div>

<h3> If you are a new Employee, register below.</h3>

<a href="employee-registration.jsp">Register Employee.</a> <br>

</body>
</html>