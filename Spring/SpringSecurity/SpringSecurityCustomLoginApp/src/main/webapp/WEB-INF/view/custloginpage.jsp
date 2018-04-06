<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<style type="text/css">
	.failed {
	color:red;
	}
	</style>
</head>
<body>
<h1> Please Sign in</h1>
<form:form action="${pageContext.request.contextPath}/AuthenticateTheUser" method="POST">

<c:if test="${param.error != null}">
<i class="failed">Sorry! You entered invalid username/password.</i>
</c:if>
<p>
User Name: <input type = "text" name = "username"/>
</p>
<p>
Password: <input type = "password" name = "password"/>
</p>
<input type = "submit"  value="Login"/>



</form:form>





</body>

</html>