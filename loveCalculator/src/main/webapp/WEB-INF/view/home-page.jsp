<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home-Page</title>

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
		if (yname.length < 3) {
			alert("Your Name should  have atleast 3 character");
			return false;
		} 
		return true;
	}
	
function validateCrushName() {
		
		var cname = document.getElementById('CN').value;
		if (cname.length < 3) {
			alert("Crush Name should  have atleast 3 character");
			return false;
		} 
		return true;
	}

function validateCheckBox()
{
	var obj = document.getElementById('checkbox').checked;
	if(obj != null)
		{
		return true;
		}
	return false;
	}

function notBlankValidate()
{
	var yname = document.getElementById('YN').value;
	var cname = document.getElementById('CN').value;

	if (yname==null && cname==null)
		{
		alert("Field should not be blank");
			return false;
		}
		return true;
		
	}

	function saveData() {
		if (notBlankValidate() && validateYourName() && validateCrushName() && validateCheckBox())
		{
			alert("SomeIssues there");
			return true;
		}
		return false;
	}
</script>

</head>
<body>

	<h1 align="center">Welcome To LoveCalculator</h1>
	<hr>
	<form:form action="process-homepage" method="GET" name="form"
		modelAttribute="userInfo">
		<div align="center">
			<p>
				<label for="YN">Your Name: </label>
				<form:input path="userName" id="YN" />
				<form:errors path="userName" cssClass="error" />
			</p>

			<p>
				<label for="CN">Crush Name: </label>
				<form:input path="crushName" id="CN" />
				<form:errors path="crushName" cssClass="error" />
			</p>

			<p>
				<form:checkbox id="checkbox" path="termsAndCondition" value="Y" />
				<label for="checkbox">I'm agree.This is just for fun</label>
				<form:errors path="termsAndCondition" cssClass="error" />
			</p>

			<input type="submit" value="Calculate" >

		</div>
	</form:form>
</body>
</html>