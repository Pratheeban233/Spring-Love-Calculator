<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
</head>
<body>
	<h1>Your Registration is  Successful</h1>
	<h2>The details  entered by you are:  </h2>
	
	Name:  ${userRegistrationInfo.name } <br>
	User Name: ${userRegistrationInfo.userName} <br>
	Password:  ${userRegistrationInfo.password } <br>
	Country:  ${userRegistrationInfo.country } <br>
	
	Hobbies: 
	<c:forEach  var="hobby" items="${userRegistrationInfo.hobbies }">
		${hobby}
	</c:forEach>
	
	 <br>
	Gender:  ${userRegistrationInfo.gender } <br>
	
</body>
</html>