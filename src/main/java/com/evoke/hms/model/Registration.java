package com.evoke.hms.model;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Wrapper class for User and Patient Details data
 * @author rpasupuleti
 *
 */

@Component
@Scope(value="prototype")
public class Registration implements IRegistration {

	@Valid
	private HMSUser hmsUser;
	
	@Valid
	private HMSPatient hmsPatient;

	public HMSUser getHmsUser() {
		return hmsUser;
	}

	public void setHmsUser(HMSUser hmsUser) {
		this.hmsUser = hmsUser;
	}

	public HMSPatient getHmsPatient() {
		return hmsPatient;
	}

	public void setHmsPatient(HMSPatient hmsPatient) {
		this.hmsPatient = hmsPatient;
	}
	
}
