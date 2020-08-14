<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result-Page</title>
</head>
<body>
	<h1  align="center">Love Calculator</h1>
	<hr>
	
	<form:form action="register"  method="GET">
	<div align="left">
	<p> UserName is : ${userInfo.userName}</p>
	<p> CrushName is :${userInfo.crushName}</p>
	</div>
	</form:form>
	<input type="submit" value="signUp">
</body>
</html>