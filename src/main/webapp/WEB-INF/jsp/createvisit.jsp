<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visit Management</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script>
$(document).ready(function() {
    $(function() {
       $("#dateOfVisit").datepicker({
          dateFormat: 'dd-mm-yy'
       });
    });
 });
</script>
</head>
<body>
<h1>Create Visit</h1>
	<form:form name='vistmanagement' commandName="HMSVisitForm"
		action='/createvisit' method='POST'>
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
			<form:label path="dateOfVisit" class="col-sm-4 control-label text-right">Visit Date:</form:label>
			<form:input path="dateOfVisit" id="dateOfVisit" class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="dateOfVisit" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="treatmentId" class="col-sm-4 control-label text-right">Select type of Treatment:</form:label>
			<form:select path="treatmentId" class="form-control">
			<!-- 	<option value=0>Select</option> -->
				<form:options items="${treatments}" itemValue="treatmentId" itemLabel="treatmentName"/>
				</form:select>
			<div class="col-sm-8">
				<form:errors path="treatmentId" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="purpose" class="col-sm-4 control-label text-right">Purpose:</form:label>
			<form:textarea path="purpose"  class="col-sm-4 text-right"></form:textarea>
			<div class="col-sm-8">
				<form:errors path="purpose" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="scheduledFollowups" class="col-sm-4 control-label text-right">No of Scheduled Followups:</form:label>
			<form:textarea path="scheduledFollowups"  class="col-sm-4 text-right"></form:textarea>
			<div class="col-sm-8">
				<form:errors path="scheduledFollowups" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="scheduleDays" class="col-sm-4 control-label text-right">Follow-up per days:</form:label>
			<form:textarea path="scheduleDays"  class="col-sm-4 text-right"></form:textarea>
			<div class="col-sm-8">
				<form:errors path="scheduleDays" class="colorred"></form:errors>
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

</body>
</html>