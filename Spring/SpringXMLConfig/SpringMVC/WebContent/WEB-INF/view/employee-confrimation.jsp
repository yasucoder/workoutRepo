<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee - Confirmation Form</title>
</head>
<body>

The Employee is confirmed: ${employee.firstName} ${employee.lastName} 

<br> <br>
Job Type: ${employee.jobType}	

<br> <br>

Skills: ${employee.mainSkill}
<br> <br>
Operating System:
<ul>
	<c:forEach var="temp" items="${employee.operatingSystem}">
	<li> ${temp} </li>
	</c:forEach>
</ul>
</body>

</html>