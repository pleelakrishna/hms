<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Edit Visit</title>

<spring:url value="/css/admin.css" var="adminCss" />
<spring:url value="/css/registration.css" var="registrationCss" />
<link href="${adminCss}" rel="stylesheet">
<link href="${registrationCss}" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
</head>
<body class="background">
<h1>Edit Visit</h1>
	<form:form name='EditVisit' commandName="HMSVisitForm"
		action='/editvisit' method='POST'>
		<div id="error_msg" class="yhplace"></div>
		<div>
			<form:label path="patientId"
				class="col-sm-4 control-label text-right">Patient Id:</form:label>
		 <input name="patientId" value='<c:out value="${HMSVisitForm.patientId}"></c:out>' readonly="readonly">
		</div>
		<div>
			<form:label path="doctorSequenceId"
				class="col-sm-4 control-label text-right">Doctor Id:</form:label>
			<form:input path="doctorSequenceId"
				class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="doctorSequenceId" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="billId" class="col-sm-4 control-label text-right">Bill Id:</form:label>
			<form:input path="billId" class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="billId" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="treatmentId" class="col-sm-4 control-label text-right">Treatment Id:</form:label>
			<form:input path="treatmentId" class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="treatmentId" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="dateOfVisit" class="col-sm-4 control-label text-right">Visit Date:</form:label>
			<form:input path="dateOfVisit" id="dateOfVisit" class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="dateOfVisit" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="purpose" class="col-sm-4 control-label text-right">Purpose:</form:label>
			<form:textarea path="purpose"  class="col-sm-4 text-right"></form:textarea>
			<div class="col-sm-8">
				<form:errors path="purpose" class="colorred"></form:errors>
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
		<!-- Hidden varaibles -->
		<form:hidden path="vistSequenceId"/>
	</form:form>
	
</body>
<script>
$(document).ready(function() {
    $(function() {
       $("#dateOfVisit").datepicker({
          dateFormat: 'dd-mm-yy'
       });
    });
 });
</script>
</html>