<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
</head>
<body class="background">

	<div class="loginDiv login-box">
		<div>
			<h1>Login Page</h1>
		</div>
		<form name='loginForm'
			action="${pageContext.request.contextPath}/login" method='POST'>

			<table>
				<tr>
					<td>User Name:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Submit" class="btn btn_red" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>