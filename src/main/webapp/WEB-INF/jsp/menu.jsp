<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.o`rg/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- META SECTION -->
<link href="css/registration.css" rel="stylesheet" type="text/css">
<title>HMS</title>
<body class="background">
	<div>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<ul>
				<li class="accessli"><input type="button"
					onclick="location.href='/registration'"
					value="User Registration" class="btn btn_blue"></li>
				<li class="accessli"><input type="button"
					onclick="location.href='/searchprofile'" value="Edit Patient Profile"
					class="btn btn_blue"></li>
				<li class="accessli"><input type="button"
					onclick="location.href='/deleteprofile'" value="Delete Patient"
					class="btn btn_blue"></li>
				<li class="accessli"><input type="button"
					onclick="location.href='/createvisit'" value="Create Visit"
					class="btn btn_blue"></li>
				<li class="accessli"><input type="button"
					onclick="location.href='/managevisits'" value="Visit Management"
					class="btn btn_blue"></li>
					<li class="accessli"><input type="button"
					onclick="location.href='/paybill'" value="Bill Payment"
					class="btn btn_blue"></li>
			</ul>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_PATIENT')">
			<ul>
				<li class="accessli"><input type="button"
					onclick="location.href='/patient/profile'" value="Profile"
					class="btn btn_blue"></li>
				<li class="accessli"><input type="button"
					onclick="location.href='/patient/billinfo'"
					value="Bill Information" class="btn btn_blue"></li>
				<li class="accessli"><input type="button"
					onclick="location.href='/patient/visitinfo'"
					value="Visit information" class="btn btn_blue"></li>
			</ul>
		</security:authorize>

	</div>
</body>