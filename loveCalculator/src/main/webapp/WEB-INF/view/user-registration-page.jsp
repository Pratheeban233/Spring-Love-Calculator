<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>

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
				<form:errors path="name" cssClass="error" />
			</p>

			<p>
				<label>User Name:</label>
				<form:input path="userName" />
				<form:errors path="userName" cssClass="error" />
			</p>

			<p>
				<label>Password:</label>
				<form:password path="password" />
				<form:errors path="password" cssClass="error" />
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
				<form:checkbox path="hobbies" value="programming" />
				Programming
				<form:checkbox path="hobbies" value="pubg" />
				PUBG
				<form:checkbox path="hobbies" value="cricket" />
				Cricket
			</p>
			<p>
				<label>Gender:</label> Male
				<form:radiobutton path="gender" value="Male" />
				Female
				<form:radiobutton path="gender" value="Female" />
			</p>
			<p>
				<label>Age:</label>
				<form:input path="age" />
				<form:errors path="age" cssClass="error" />
			</p>

			<h3>Communication</h3>
			<p>
				<label>Email:</label>
				<form:input path="communicationDTO.email" />
				<form:errors path="communicationDTO.email" cssClass="error" />
			</p>
			<p>
				<label>Phone:</label>
				<form:input path="communicationDTO.phone" />
				<form:errors path="communicationDTO.phone" cssClass="error" />
			</p>

			<input type="submit" value="Register">
		</div>
	</form:form>

</body>
</html>