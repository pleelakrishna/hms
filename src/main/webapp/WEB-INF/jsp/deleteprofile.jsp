<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%-- <c:choose>
		<c:when test="${row.file_name != null}">
        Not Null
    </c:when>
		<c:otherwise>
        Null
    </c:otherwise>
    request.getAttribute("javax.servlet.forward.request_uri")
	</c:choose> --%>
	<form:form name='DeleteProfile' action='/deleteprofile' method='POST'>
		<div class="form-group col-md-6">
			<table>
				<tr>
					<td>Enter HMS Unique ID:</td>
					<td><input type="text" name="hmsId" size="15" /></td>
					<td><input type="submit" id="search User" value="Delete User"
						class="btn btn_red"></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>