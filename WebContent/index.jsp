<%@page import="com.user.controller.users" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>User Details</h1>
				<form id="formUser" name="formUser">
					
					firstName: <input id="firstName" name="firstName" type="text"
						class="form-control form-control-sm">
						 <br>
					lastName: <input
						id="lastName" name="lastName" type="text"
						class="form-control form-control-sm">
						 <br>
					userAddress : <input id="userAddress" name="userAddress"
						type="text" class="form-control form-control-sm"> 
						<br>
					contactNumber : <input id="contactNumber" name="contactNumber"
						type="text" class="form-control form-control-sm"> 
						<br>
					userDOB : <input id="userDOB" name="userDOB"
						type="text" class="form-control form-control-sm"> 
						<br>
					userAge : <input id="userAge" name="userAge"
						type="text" class="form-control form-control-sm"> 
						<br>
					userEmail : <input id="userEmail" name="userEmail"
						type="text" class="form-control form-control-sm"> 
						<br>
					  <input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hiduserIdSave" name="hiduserIdSave" value="">
				</form>
			<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>  
				<div id="divusersGrid">
				<%
					users userObj = new users();
					out.print(userObj.readUser());
					%>
				</div>

			</div>
		</div>
	</div>

</body>
</html>