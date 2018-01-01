package com.evoke.hms.business;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component(value="RegistrationBusinessObject")
@Scope(value="prototype")
public class RegistrationBusinessModel implements IRegistrationBusinessModel {

	@Valid
	private IHMSUserBusinessModel hmsUser;
	
	@Valid
	private IHMSPatientBusinessModel hmsPatient;
	
	@Valid
	private IHMSDoctorBusinessModel hmsDoctor;

	public IHMSUserBusinessModel getHmsUser() {
		return hmsUser;
	}

	public void setHmsUser(IHMSUserBusinessModel hmsUser) {
		this.hmsUser = hmsUser;
	}

	public IHMSPatientBusinessModel getHmsPatient() {
		return hmsPatient;
	}

	public void setHmsPatient(IHMSPatientBusinessModel hmsPatient) {
		this.hmsPatient = hmsPatient;
	}

	public IHMSDoctorBusinessModel getHmsDoctor() {
		return hmsDoctor;
	}

	public void setHmsDoctor(IHMSDoctorBusinessModel hmsDoctor) {
		this.hmsDoctor = hmsDoctor;
	}
	
}
