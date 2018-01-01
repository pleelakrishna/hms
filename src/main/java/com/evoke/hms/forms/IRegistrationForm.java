package com.evoke.hms.forms;

public interface IRegistrationForm {
	HMSUserForm getHmsUserForm();
	void setHmsUserForm(HMSUserForm hmsUserForm);
	HMSPatientForm getHmsPatientForm();
	void setHmsPatientForm(HMSPatientForm hmsPatientForm);
	public HMSDoctorForm getHmsDoctorForm();
	public void setHmsDoctorForm(HMSDoctorForm hmsDoctorForm);
}
