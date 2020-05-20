<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h1 align="center">Love Calculator - Registration</h1>
	<hr>

	<form:form action="register-success" method="GET"
		modelAttribute="userRegistrationInfo">
		<div align="center">
			<p>
				<label>Name :</label>
				<form:input path="name" />
			</p>

			<p>
				<label>User Name:</label>
				<form:input path="userName" />
			</p>

			<p>
				<label>Password:</label>
				<form:password path="password" />
			</p>

			<p>
				<label>Country:</label>
				<form:select path="country">
					<form:option value="India" label="INDIA"></form:option>
					<form:option value="United State" label="USA"></form:option>
					<form:option value="Australia" label="AUSTRALIA"></form:option>
					<form:option value="England" label="ENGLAND"></form:option>
				</form:select>
			</p>
			<p>
				<label>Hobbies:</label>
				<form:checkbox path="hobbies" value="1.programming" />
				Programming
				<form:checkbox path="hobbies" value="2.pubg" />
				PUBG
				<form:checkbox path="hobbies" value="3.cricket" />
				Cricket
			</p>
			<p>
				<label>Gender:</label> Male
				<form:radiobutton path="gender" value="Male" />
				Female
				<form:radiobutton path="gender" value="Female" />
			</p>

			<h3>Communication</h3>
			<p>
				<label>Email:</label>
				<form:input path="CommunicationDTO.email" />
				
				<label>Phone:</label>
				<form:input path="CommunicationDTO.phone" />
			</p>

			<input type="submit" value="Register">
		</div>
	</form:form>

</body>
</html>