<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send-Email-Page</title>
</head>
<body>

<h1>Hi ${userInfo.userName} </h1>
<form:form action="process-Email" method="GET" modelAttribute="emailDto">

<label>Enter Your Email</label>
<form:input path="userEmail"/>
<button type="submit">send</button>

</form:form>


</body>
</html>