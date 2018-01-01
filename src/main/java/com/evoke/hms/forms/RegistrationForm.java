package com.evoke.hms.forms;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="prototype")
public class RegistrationForm implements IRegistrationForm {

	@Valid
	private HMSUserForm hmsUserForm;
	
	@Valid
	private HMSPatientForm hmsPatientForm;
	
	@Valid
	private HMSDoctorForm hmsDoctorForm;
	
	public HMSDoctorForm getHmsDoctorForm() {
		return hmsDoctorForm;
	}

	public void setHmsDoctorForm(HMSDoctorForm hmsDoctorForm) {
		this.hmsDoctorForm = hmsDoctorForm;
	}

	public HMSUserForm getHmsUserForm() {
		return hmsUserForm;
	}

	public void setHmsUserForm(HMSUserForm hmsUserForm) {
		this.hmsUserForm = hmsUserForm;
	}

	public HMSPatientForm getHmsPatientForm() {
		return hmsPatientForm;
	}

	public void setHmsPatientForm(HMSPatientForm hmsPatientForm) {
		this.hmsPatientForm = hmsPatientForm;
	}

	
	
}
