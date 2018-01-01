package com.evoke.hms.converters.FormToVO;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSDoctorBusinessModel;
import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.business.IHMSUserBusinessModel;
import com.evoke.hms.business.IRegistrationBusinessModel;
import com.evoke.hms.business.RegistrationBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.forms.IRegistrationForm;

@Component
public class RegistrationFormToBusinessConverter extends HMSAbstractConverter<IRegistrationForm, IRegistrationBusinessModel> {
	
	private ObjectFactory<IHMSPatientBusinessModel> hmsPatientObj;
	private ObjectFactory<IHMSUserBusinessModel> hmsUserObj;
	private ObjectFactory<IHMSDoctorBusinessModel> hmsDoctorObj ;
	private  ObjectFactory<RegistrationBusinessModel> registration;
	
	@Autowired
	public void setHmsPatientObj(ObjectFactory<IHMSPatientBusinessModel> hmsPatientObj) {
		this.hmsPatientObj = hmsPatientObj;
	}

	@Autowired
	public void setHmsUserObj(ObjectFactory<IHMSUserBusinessModel> hmsUserObj) {
		this.hmsUserObj = hmsUserObj;
	}

	@Autowired
	public void setHmsDoctorObj(ObjectFactory<IHMSDoctorBusinessModel> hmsDoctorObj) {
		this.hmsDoctorObj = hmsDoctorObj;
	}

	@Autowired
	public void setRegistration(ObjectFactory<RegistrationBusinessModel> registration) {
		this.registration = registration;
	}
		
	@Override
	public IRegistrationBusinessModel convert(IRegistrationForm source) {
		IHMSPatientBusinessModel hmsPatient = hmsPatientObj.getObject(); 
		IHMSUserBusinessModel hmsUser = hmsUserObj.getObject();
		IHMSDoctorBusinessModel hmsDoctor = hmsDoctorObj.getObject();
		RegistrationBusinessModel registr = registration.getObject();
		copyUtils(source.getHmsPatientForm(), hmsPatient);
		copyUtils(source.getHmsUserForm(), hmsUser);
		copyUtils(source.getHmsDoctorForm(), hmsDoctor);
		registr.setHmsPatient(hmsPatient);
		registr.setHmsUser(hmsUser);
		registr.setHmsDoctor(hmsDoctor);
		setFactoryObject(registr);
		return super.convert(source);
	}

}
