<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
</head>
<body>
<body>
	<form:form name='editprofile_form' commandName="HMSPatientForm"
		action='/updateprofile' method='POST'>
		<div id="error_msg" class="yhplace"></div>
		<div class="form-group ">
			<form:label path="emergencyContactName"
				class="col-sm-4 control-label text-right">Emergency
				Name :</form:label>
			<div class="col-sm-8">
				<form:input path="emergencyContactName" type="text"
					class="form-control" placeholder="Emergency Name"
					id="EmergencyName"></form:input>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="emergencyContactNumber"
				class="col-sm-4 control-label text-right">Emergency
				Phone:</form:label>
			<div class="col-sm-8">
				<form:input path="emergencyContactNumber" type="text"
					class="form-control" id="EmergencyPhone"
					placeholder="Emergency Phone"></form:input>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="maritalStatus"
				class="col-sm-4 control-label text-right">Marital
				Status:</form:label>
			<div class="col-sm-8">
				<form:select path="maritalStatus"
					class="form-control" id="maritalStatus">
					<form:option value=''>select</form:option>
					<form:option value="Married">Married</form:option>
					<form:option value="Single">Single</form:option>
					<form:option value="Divorced">Divorced</form:option>
				</form:select>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="bloodGroup"
				class="col-sm-4 control-label text-right">Blood Group:</form:label>
			<div class="col-sm-8">
				<form:select path="bloodGroup" class="form-control"
					id="BloodGroup">
					<form:option value=''>Select</form:option>
					<form:option value="O(+ve)">O(+ve)</form:option>
					<form:option value="O(-ve)">O(-ve)</form:option>
					<form:option value="A(-ve)">A(-ve)</form:option>
					<form:option value="A(+ve)">A(+ve)</form:option>
					<form:option value="B(-ve)">B(-ve)</form:option>
					<form:option value="B(+ve)">B(+ve)</form:option>
					<form:option value="AB(+ve)">AB(+ve)</form:option>
					<form:option value="AB(-ve)">AB(-ve)</form:option>
				</form:select>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="allergicTo"
				class="col-sm-4 control-label text-right">Allergic To:</form:label>
			<div class="col-sm-8">
				<form:input path="allergicTo" type="text"
					class="form-control" placeholder="Allergic To" id="AllergicDetails"></form:input>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="diabetes" input="diabetes"
				class="col-sm-4 control-label text-right">Diabetes:</form:label>
			<div class="col-sm-4">
				<form:radiobutton path="diabetes" value="true"
					id="diabetes" />
				Yes
			</div>
			<div class="col-sm-4">
				<form:radiobutton path="diabetes" value="false"
					id="diabetes" />
				No
			</div>
		</div>
		<div class="form-group ">
			<form:label path="bloodPressure" input="bloodPressure"
				class="col-sm-4 control-label text-right">BloodPressure:</form:label>
			<div class="col-sm-4">
				<form:radiobutton path="bloodPressure" value="true"
					id="bloodPressure" />
				Yes
			</div>
			<div class="col-sm-4">
				<form:radiobutton path="bloodPressure" value="false"
					id="bloodPressure" />
				No
			</div>
		</div>
		<div class="form-group ">
			<form:label path="smoking"
				class="col-sm-4 control-label text-right">Smoking:</form:label>
			<div class="col-sm-4">
				<form:radiobutton path="smoking" id="smoking"
					value="true" />
				Yes
			</div>
			<div class="col-sm-4">
				<form:radiobutton path="smoking" id="smoking"
					value="false" />
				No
			</div>
		</div>
		<div class="form-group ">
			<form:label path="alcoholic"
				class="col-sm-4 control-label text-right">Alcoholic:</form:label>
			<div class="col-sm-4">
				<form:radiobutton path="alcoholic" value="true"
					id="alcoholic" />
				Yes
			</div>
			<div class="col-sm-4">
				<form:radiobutton path="alcoholic" value="false"
					id="alcoholic" />
				No
			</div>
		</div>

		<div class="col-md-offset-4 col-md-8" id="surgeryblock">
			<form:label path="previousSurgeryDetails"
				class="col-sm-4 control-label text-right">Previous
					Surgery:</form:label>
			<form:input path="previousSurgeryDetails"
				class="form-control" placeholder="Surgery Details"
				id="surgerydetails" />
		</div>
		<!-- Hidden variable to hold hmsunique ID -->
		<div>
			<form:hidden path="hmsUniqueId" />
			<%-- <form:hidden path="userId" /> --%>
			<form:hidden path="patientId" />
		</div>
		<div class="clearfix"></div>
		<div class="form-group col-md-6">
			<div class="col-sm-8">
				<div class="action_btns">
					<input type="submit" id="submit_btn" value="Submit"
						class="btn btn_red">
				</div>
			</div>
		</div>
	</form:form>
</html>