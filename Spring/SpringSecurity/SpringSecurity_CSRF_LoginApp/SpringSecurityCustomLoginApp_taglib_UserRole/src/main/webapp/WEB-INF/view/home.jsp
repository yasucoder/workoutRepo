<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Spring Security home page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	<h2>Spring Security home page</h2>
	<hr>
	Hello World Spring Security 
	<p>
	<!-- Display UserName and role -->
	User: <security:authentication property="principal.username" />
	<br><br>
	Role(s): <security:authentication property="principal.authorities" />
	</p>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST" class="form-horizontal">
		<!-- logout/Submit Button -->
		<div style="margin-top: 10px" class="form-group">						
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-success">Logout</button>
			</div>
		</div>
	</form:form>
</body>

</html>