<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee Registration Form</title>
</head>
<body>

	<form:form action="processform" ModelAttribute="employee" commandName="employee">
	First Name: <form:input path="firstName" />
	<br><br>
	Last Name: <form:input path="lastName" />
	<br><br>
	Job Type: 
	<form:select path="jobType">
	<form:options items="${employee.jobtypeOptions}"/>
	<%-- <form:option value="FullTime" label="FullTime"></form:option>
	<form:option value="Contract" label="Contract"></form:option> --%>
	</form:select>
	<br><br>
	Skills:
	Java <form:radiobutton path="mainSkill" value="Java"/>
	C# <form:radiobutton path="mainSkill" value="C#"/>
	PHP <form:radiobutton path="mainSkill" value="PHP"/>
	Ruby <form:radiobutton path="mainSkill" value="Ruby"/>
	
	<br><br>
	Operating System:
	<br>
	Linux <form:checkbox path="operatingSystem" value="Linux"/>
	Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
	MS Windows <form:checkbox path="operatingSystem" value="MS Windows"/>

	<br><br>
	<input type="submit" value="Submit" />
	</form:form>
</body>

</html>