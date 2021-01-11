<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1 align="center">Love Calculator - Registration</h1>
	<hr>
	
	<form:form action="process-main" method="GET"
		modelAttribute="userInfo" >
		<div align="center">
	<p>
		<label for="uname">UserName:</label>
		<form:input path="userName" id="uname"/>
	</p>
	<p>
		<label for="pass">Password:</label>
		<form:input path="password" id="pass"/>
	</p>
	
	<input type="submit" value="Signin">
	
	</div>
	</form:form>
	
</body>
</html>