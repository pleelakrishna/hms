<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
</head>
<body class="background">
	<h1>Welcome to Health Care Management Systems</h1>
	<div>
	 <img src="img/HMS.png" alt="HMSLOGO" height="250" width="1050"> 
	</div>
	<div class="loginDiv  login-box">
		<form id="loginform" enctype='application/json'>
				<div>
				<input type="button"  class ="loginBtn btn btn_red" onclick="location.href='/login'" value="Login" >
				</div>
				<div><hr/></div>
				<div>
					<a href="#" class="forgot_password"
						onClick="Show_forgotPassword_Div()">Forgot password?</a>
				</div>
		</form>
	</div>
</body>
</html>