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
	
	<form:form>
	<h2>The Love calculator predicts : </h2>
	<div align="left">
	<h3>${userInfo.userName} and ${userInfo.crushName} are </h3>
	FRIEND
	<br>
	</div>
	</form:form>
	<br>
	<%-- <a href="/loveCalculator/sendEmail/${userInfo.userName}">Send the result to your email</a> --%>
	<a href="/loveCalculator/sendEmail">Send the result to your email</a>
	
</body>
</html>