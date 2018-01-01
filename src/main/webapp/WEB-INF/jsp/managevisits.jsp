<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CreateVisit</title>
<link href="css/admin.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
</head>
<body>
	<h1>Visit Management</h1>
	<form:form name='managevists' commandName="ManageVisitsForm">
		<div id="error_msg" class="yhplace"></div>
		<div>
			<form:label path="patientId"
				class="col-sm-4 control-label text-right">Patient Id:</form:label>
			<form:input path="patientId"
				class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="patientId" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="doctorId" class="col-sm-4 control-label text-right">Doctor Id:</form:label>
			<form:input path="doctorId"
				class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="doctorId" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="dateOfVisit"
				class="col-sm-4 control-label text-right">Visit Date:</form:label>
			<form:input path="dateOfVisit" id="dateOfVisit"
				class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="dateOfVisit" class="colorred"></form:errors>
			</div>
		</div>
		<div class="form-group col-md-6">
			<div class="col-sm-8">
				<div class="action_btns">
					<input type="submit" id="createvisit_btn" value="Submit"
						class="btn btn_red">
				</div>
			</div>
		</div>
		</form:form>
		<!-- Showing list of visits by default -->
		<table>
			<tr>
				<th>Visit Sequence Id</th>
				<th>Doctor Sequence Id</th>
				<th>Date of Visit</th>
				<th>Treatment Id</th>
				<th>Purpose</th>
			</tr>
			<c:forEach items="${ManageVisitsForm.hmsVisits}" var="hmsVisit"
				varStatus="status">
				<tr>
					<td>${hmsVisit.vistSequenceId}</td>
					<td>${hmsVisit.doctorId}</td>
					<td>${hmsVisit.dateOfVisit}</td>
					<td>${hmsVisit.treatmentId}</td>
					<td>${hmsVisit.purpose}</td>
					<td>
					<spring:url value="/editvisit/${hmsVisit.vistSequenceId}" var="editURL" htmlEscape="true" />
					<spring:url value="/deletevisit/${hmsVisit.vistSequenceId}" var="deleteURL" htmlEscape="true" />
					<spring:url value="/viewvisit/${hmsVisit.vistSequenceId}" var="viewURL" htmlEscape="true" />
					<!-- 
					<button class="btn btn-info" 
                                          onclick="location.href='${editURL}'">EDIT</button>
                                       -->
                    <a href="${editURL}">Edit</a>
                     <a href="${deleteURL}">Delete</a>
                     <%--  <a href="${viewURL}">View</a> --%>
					 
					<%--
					<a href="<c:url value="/editvisit/${hmsVisit.vistSequenceId}"/>">Edit</a>
					<a href="${'editVisit'}?id=${hmsVisit.vistSequenceId}"> Edit</a></td>
					 <td><button id="btnEdit" name="action" type="submit" value="Edit${hmsVisit.vistSequenceId}" onclick="">Edit</button></td>
					<td><button id="btnDelete" name="action" type="submit" value="Delete${hmsVisit.vistSequenceId}">Delete</button></td>
					<td><button id="btnView" name="action" type="submit" value="View${hmsVisit.vistSequenceId}" onclick="">View</button></td> --%>
				</tr>
			</c:forEach>
		</table>

</body>
<script>
	$(document).ready(function() {
		$(function() {
			$("#dateOfVisit ").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	});
</script>
</html>