<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/registration.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
</head>
<body>
	<form:form name='register_form' commandName="RegistrationForm"
		action='/registeruser' method='POST'>
		<div id="error_msg" class="yhplace"></div>
		<div class="form-group ">
			<form:label path="hmsUserForm.userLoginId"
				class="col-sm-4 control-label text-right">User Name:</form:label>
			<div class="col-sm-8">
				<form:input path="hmsUserForm.userLoginId" type="text"
					class="form-control" placeholder="user name"></form:input>
			</div>
			<div class="col-sm-8">
				<form:errors path="hmsUserForm.userLoginId" class="colorred"></form:errors>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="hmsUserForm.userPassword"
				class="col-sm-4 control-label text-right">Pass word:</form:label>
			<div class="col-sm-8">
				<form:input type="password" path="hmsUserForm.userPassword"
					class="form-control" placeholder="password"></form:input>
			</div>
			<div class="col-sm-8">
				<form:errors path="hmsUserForm.userPassword" class="colorred"></form:errors>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="" class="col-sm-4 control-label text-right">Confirm
				Password:</form:label>
			<div class="col-sm-8">
				<form:input path="" type="password" class="form-control"
					placeholder="confirm password"></form:input>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="hmsUserForm.firstName"
				class="col-sm-4 control-label text-right">First Name:</form:label>
			<form:input path="hmsUserForm.firstName"
				class="col-sm-4 control-label text-right" placeholder="First Name"></form:input>
			<div class="col-sm-8">
				<form:errors path="hmsUserForm.firstName" class="colorred"></form:errors>
			</div>

		</div>
		<div class="form-group ">
			<form:label path="hmsUserForm.lastName"
				class="col-sm-4 control-label text-right">Last Name:</form:label>
			<form:input path="hmsUserForm.lastName"
				class="col-sm-4 control-label text-right" placeholder="Last Name"></form:input>
		</div>
		<div class="form-group ">
			<form:label path="hmsUserForm.email"
				class="col-sm-4 control-label text-right">Email:</form:label>
			<div class="col-sm-8">
				<form:input path="hmsUserForm.email" type="email"
					id="Email" class="form-control" placeholder="Email" maxlength="75"></form:input>
			</div>
			<div class="col-sm-8">
				<form:errors path="hmsUserForm.email" class="colorred"></form:errors>
			</div>
		</div>
		<div class="form-group ">
			<form:label path="hmsUserForm.DOB"
				class="col-sm-4 control-label text-right">Date of
				Birth:</form:label>
			<div class="col-sm-8">
				<form:input path="hmsUserForm.DOB" type="text"
					class="form-control" id="datepicker" placeholder="Date of Birth" />
			</div>
			<div class="col-sm-8">
				<form:errors path="hmsUserForm.DOB" class="colorred" />
			</div>
		</div>
		<div class="form-group ">
			<form:label path="hmsUserForm.gender"
				class="col-sm-4 control-label text-right">Gender:</form:label>
			<div class="col-sm-8">
				<form:select path="hmsUserForm.gender" class="form-control"
					name="hmsUserForm[gender]" id="Gender">
					<option value=''>select</option>
					<option>Male</option>
					<option>Female</option>
					<option>TransGender</option>
				</form:select>
			</div>
		</div>
		<!-- Loading roles -->
		<div class="form-group ">
			<form:label path="" class="col-sm-4 control-label text-right">Select User ROLE:</form:label>
			<div class="col-sm-8">
				<%--  <form:select path="hmsUserForm.userRole" class="form-control">
				<form:options items="${roles}" itemValue="AppRoleId" itemLabel="AppRolesName"/>
				</form:select> --%>
			 	<form:checkboxes path="hmsUserForm.rolesIds" items="${roles}"
					itemLabel="AppRolesName" itemValue="AppRoleId" /> 
			</div>
		</div>
		<hr>
		
		<!-- Patient div starts -->
		<div class="2 divHidden">

			<div class="form-group ">
				<form:label path="hmsPatientForm.phoneNumber"
					class="col-sm-4 control-label text-right">Phone No:</form:label>
				<div class="col-sm-8">
					<form:input path="hmsPatientForm.phoneNumber" type="text"
						class="form-control" placeholder="Phone No" id="PhoneNumber"></form:input>
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.emergencyContactName"
					class="col-sm-4 control-label text-right">Emergency
				Name :</form:label>
				<div class="col-sm-8">
					<form:input path="hmsPatientForm.emergencyContactName" type="text"
						class="form-control" placeholder="Emergency Name"
						id="EmergencyName"></form:input>
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.emergencyContactNumber"
					class="col-sm-4 control-label text-right">Emergency
				Phone:</form:label>
				<div class="col-sm-8">
					<form:input path="hmsPatientForm.emergencyContactNumber"
						type="text" class="form-control" id="EmergencyPhone"
						placeholder="Emergency Phone"></form:input>
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.maritalStatus"
					class="col-sm-4 control-label text-right">Marital
				Status:</form:label>
				<div class="col-sm-8">
					<form:select path="hmsPatientForm.maritalStatus"
						class="form-control" id="maritalStatus">
						<option value=''>select</option>
						<option>Married</option>
						<option>Single</option>
						<option>Divorced</option>
					</form:select>
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.bloodGroup"
					class="col-sm-4 control-label text-right">Blood Group:</form:label>
				<div class="col-sm-8">
					<form:select path="hmsPatientForm.bloodGroup" class="form-control"
						id="BloodGroup">
						<option value=''>Select</option>
						<option>O(+ve)</option>
						<option>O(-ve)</option>
						<option>A(-ve)</option>
						<option>A(+ve)</option>
						<option>B(-ve)</option>
						<option>B(+ve)</option>
						<option>AB(+ve)</option>
						<option>AB(-ve)</option>
					</form:select>
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.allergicTo"
					class="col-sm-4 control-label text-right">Allergic To:</form:label>
				<div class="col-sm-8">
					<form:input path="hmsPatientForm.allergicTo" type="text"
						class="form-control" placeholder="Allergic To"
						id="AllergicDetails"></form:input>
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.diabetes" input="diabetes"
					class="col-sm-4 control-label text-right">Diabetes:</form:label>
				<div class="col-sm-4">
					<form:radiobutton path="hmsPatientForm.diabetes" value="true"
						id="diabetes" />
					Yes
				</div>
				<div class="col-sm-4">
					<form:radiobutton path="hmsPatientForm.diabetes" value="false"
						id="diabetes" />
					No
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.bloodPressure"
					input="bloodPressure" class="col-sm-4 control-label text-right">BloodPressure:</form:label>
				<div class="col-sm-4">
					<form:radiobutton path="hmsPatientForm.bloodPressure" value="true"
						id="bloodPressure" />
					Yes
				</div>
				<div class="col-sm-4">
					<form:radiobutton path="hmsPatientForm.bloodPressure" value="false"
						id="bloodPressure" />
					No
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.smoking"
					class="col-sm-4 control-label text-right">Smoking:</form:label>
				<div class="col-sm-4">
					<form:radiobutton path="hmsPatientForm.smoking" id="smoking"
						value="true" />
					Yes
				</div>
				<div class="col-sm-4">
					<form:radiobutton path="hmsPatientForm.smoking" id="smoking"
						value="false" />
					No
				</div>
			</div>
			<div class="form-group ">
				<form:label path="hmsPatientForm.alcoholic"
					class="col-sm-4 control-label text-right">Alcoholic:</form:label>
				<div class="col-sm-4">
					<form:radiobutton path="hmsPatientForm.alcoholic" value="true"
						id="alcoholic" />
					Yes
				</div>
				<div class="col-sm-4">
					<form:radiobutton path="hmsPatientForm.alcoholic" value="false"
						id="alcoholic" />
					No
				</div>
			</div>

			<div class="col-md-offset-4 col-md-8" id="surgeryblock">
				<form:label path="hmsPatientForm.previousSurgeryDetails"
					class="col-sm-4 control-label text-right">Previous
					Surgery:</form:label>
				<form:input path="hmsPatientForm.previousSurgeryDetails"
					class="form-control" placeholder="Surgery Details"
					id="surgerydetails" />
			</div>

		</div>
		<!-- ending patient div-->
		
		<!-- Starting doctor div -->
		<div class="3 divHidden">
		<div class="form-group ">
			<form:label path="" class="col-sm-4 control-label text-right">Select Department:</form:label>
			<div class="col-sm-8">
				<form:select path="hmsDoctorForm.departmentId" class="form-control">
				<option value=0 >select</option>
				<form:options items="${departments}" itemValue="departmentId" itemLabel="departmentName"/>
				</form:select>
			</div>
		</div>
		
		</div>
		<!-- Ending doctor div -->
		
		<div class="clearfix"></div>
		<div class="form-group ">
			<div class="col-sm-8">
				<div class="action_btns">
					<input type="submit" id="register_btn" value="Register"
						class="btn btn_red">
				</div>
			</div>
		</div>
	</form:form>

</body>
<script>
	$(document).ready(function() {
		$(function() {
			$("#datepicker").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	});
</script>
<!-- Checkboxes related code -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('input[type="checkbox"]').click(function() {
			if ($(this).attr("value") == 1) {
				$(".1").toggle();
			}
			if ($(this).attr("value") == 2) {
				$(".2").toggle();
			}
			if ($(this).attr("value") == 3) {
				$(".3").toggle();
			}
		});
	});
</script>
</html>