<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration Page</title>
</head>
<body>

<h1> Welcome to the Employee registration page.</h1>

<form action="employee-reg.jsp" method="post">

		<label> First Name:</label>
        <input placeholder="FIRST NAME" type="text" name="firstName"/> <br>
        
        <label> Surname:</label>
        <input placeholder="SURNAME" type="text" name="surname"/> <br>
        
         <label> Gender:</label>
        <input placeholder="GENDER" type="text" name="gender"/> <br>
        
         <label> Date Of Birth:</label>
        <input placeholder="D.O.B" type="text" name="dateOfBirth"/> <br>
        
         <label> Identification Number :</label>
        <input placeholder="ID Number" type="text" name="idNumber"/> <br>
        
         <label> Position:</label>
        <input placeholder="POSITION" type="text" name="position"/> <br>
        
        <label> Email Address:</label>
        <input placeholder="EMAIL" type="text" name="emailAddress"/> <br>
        
        <label> Marital Status:</label>
        <input placeholder="MR/MS/MISS/MRS/OTHER" type="text" name="maritalStatus"/> <br>
        
        <label> Residential Address:</label>
        <input type="text" name="residentialAddress"/> <br>
        
        <label> Phone Number:</label>
        <input placeholder="PHONR NUMBER" type="number" name="phoneNumber"/> <br>
        
		<label> User Name:</label>
        <input placeholder="USER NAME" type="text" name="userName"/> <br>

        <label>Password:</label>
        <input placeholder="PASSWORD"  type="password" name="password"/> <br>


        <button>Submit</button>
</form>

<h3> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h3>

</body>
</html>