<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body class="background">
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h1> Admin Page</h1>
		<label>Welcome :: <b>${pageContext.request.userPrincipal.name}</b></label>
		<h3>${message}</h3>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_PATIENT')">
		<h1>Patient Page</h1>
		<label>Welcome :: <b>${pageContext.request.userPrincipal.name}</b></label>
		<h3>${message}</h3>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_DOCTOR')">
	<h1>Message : Welcome to Doctor Page</h1>
		<label>Welcome Doctor:: <b>${pageContext.request.userPrincipal.name}</b></label>
		<h3>${message}</h3>
	</sec:authorize>
	<c:url value="${pageContext.request.contextPath}/logout"
		var="logoutUrl" />
	<form id="logout" action="${logoutUrl}" method="post"></form>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
</body>
</html>