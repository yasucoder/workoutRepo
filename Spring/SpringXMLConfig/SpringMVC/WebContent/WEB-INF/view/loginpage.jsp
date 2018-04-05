<!DOCTYPE html>
<html>
<head>
<title>MySpringDemo - Login Form</title>
</head>
<body>

	<form:form action=processForm ModelAttribute="employee">
	First Name: <form:input path="firstName" />
	<br><br>
	LastName: <form:input path="lastName" />
	<br><br>
	<input type="sumbit" value="Submit" />
	</form:form>
</body>

</html>