<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Renter Registration Form</title>
<style type="text/css">
	.error{color:red}
</style>
</head>
<body>
	<a> Fill out the form.Asterisk(*) means required. </a>
	<br><br>
	<form:form action="processform" ModelAttribute="renter" commandName="renter">
	First Name: <form:input path="firstName" />
	<br><br>
	Last Name (*): <form:input path="lastName" />
	<form:errors path="lastName" cssClass="error" />
	<br><br>
	Parking Space (*): <form:input path="parkinglot" />
	<form:errors path="parkinglot" cssClass="error" />
	<br><br>
	Postal Code (*): <form:input path="postalCode" />
	<form:errors path="postalCode" cssClass="error" />
	<br><br>
	Course Code: <form:input path="aptCode" />
	<form:errors path="aptCode" cssClass="error" />
	<br><br>
	
	<input type="submit" value="Submit" />
	</form:form>
</body>

</html>