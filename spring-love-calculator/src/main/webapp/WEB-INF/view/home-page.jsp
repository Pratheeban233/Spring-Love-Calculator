<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>

<script type="text/javascript">
	function validateYourName() {
		
		var yname = document.getElementById('YN').value;
		alert("Your Name should  have atleast 3 character");
		if (yname.length < 3) {
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body>

	<h1 align="center">Welcome To LoveCalculator</h1>
	<hr>
	<form:form action="process-homepage" method="GET"
		modelAttribute="userInfo" >
		<div align="center">
			<p>
				<label for="YN">Your Name: </label>
				<form:input path="yourName" id="YN" />
				<form:errors path="yourName" cssClass="error" />
			</p>

			<p>
				<label for="CN">Crush Name: </label>
				<form:input path="crushName" id="CN" />
				<form:errors path="crushName" cssClass="error" />
			</p>

			<p>
				<form:checkbox path="termsAndCondition" />
				<label>I'm agree this is jsut for fun</label>
				<form:errors path="termsAndCondition" cssClass="error" />
			</p>

			<input type="submit" value="Calculate">

		</div>
	</form:form>
</body>
</html>