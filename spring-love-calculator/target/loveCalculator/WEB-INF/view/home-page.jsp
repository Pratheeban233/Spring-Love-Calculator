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
	function validateUserName() {
		alert("Your Name should  have atleast 3 character");
		var yname = document.getElementById('YN').value;
		if (yname.length < 3) {
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body>

	<h1>WelCome To LoveCalculator</h1>
	<hr>
	<form:form action="process-homepage" method="GET"
		onsubmit="return validateUserName()">
		<div>
			<p>
				<label for="YN">Your Name: </label>
				<form:input path="yourName" id="YN" />
				<form:errors path="yourName" cssClass="error" />
			</p>

			<p>
				<label for="CN">Crush Name: </label>
				<form:input path="crushName" id="CN" />
				<form:errors path="yourName" cssClass="error" />
			</p>

			<form:checkbox path="termsAndCondition" />
			<label>I'm agree this is jsut for fun</label> <input type="submit"
				value="Calculate">
			<form:errors path="yourName" cssClass="error" />

		</div>
	</form:form>
</body>
</html>