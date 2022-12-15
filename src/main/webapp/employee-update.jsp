<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee's Information</title>
</head>
<body>

<h1> Update Employee's Information Below</h1>

<form action="employee-upd.jsp" method="post">

	
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
	     <input placeholder="PHONE NUMBER" type="number" name="phoneNumber"/> <br>
        
		<label> User Name:</label>
        <input placeholder="USER NAME" type="text" name="userName"/> <br>

        <label>Password:</label>
        <input placeholder="PASSWORD"  type="password" name="password"/> <br>

		<label> Staff Number:</label>
        <input placeholder=" STAFF NUMBER " type="text" name="staffNumber"/> <br>		
		
        <button>Submit</button>
</form>

<div>
<h2>
<%String message = (String) request.getAttribute("MESSAGE");
out.println(message);
%>

</h2>

</div>

<h3> 

<a href="menu.jsp">Back to the Menu.</a> <br>

</h3>
</body>
</html>