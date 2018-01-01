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
       $("#date").datepicker({
          dateFormat: 'dd-mm-yy'
       });
    });
 });
</script>
</head>
<body>
<h1>Pay Bill</h1>
	<form:form name='Pay Bill' commandName="HMSPayBillForm"
		action='/paybill' method='POST'>
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
			<form:label path="validFrom" class="col-sm-4 control-label text-right">Valid From:</form:label>
			<form:input path="validFrom" id="date" class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="validFrom" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="validTo" class="col-sm-4 control-label text-right">Valid To:</form:label>
			<form:input path="validTo" id="date" class="col-sm-4 textboxwidth80 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="validTo" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="treatmentIdList" class="col-sm-4 control-label text-right">Select type of Treatment:</form:label>
			<form:select multiple="true" path="treatmentIdList" class="form-control">
				<form:options items="${treatments}" itemValue="treatmentId" itemLabel="treatmentName"/>
				</form:select>
			<div class="col-sm-8">
				<form:errors path="treatmentId" class="colorred"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="amountPaid" class="col-sm-4 control-label text-right">Amount Paid:</form:label>
			<form:input path="amountPaid"  class="col-sm-4 text-right"></form:input>
			<div class="col-sm-8">
				<form:errors path="amountPaid" class="colorred"></form:errors>
			</div>
		</div>
		<div class="form-group col-md-6">
			<div class="col-sm-8">
				<div class="action_btns">
					<input type="submit" id="paybill_btn" value="Submit"
						class="btn btn_red">
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>