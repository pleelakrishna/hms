package com.evoke.hms.converters.FormToVO;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.forms.IRegistrationForm;

@Component
public class RegistrationFormToPatientBusinessConverter extends HMSAbstractConverter<IRegistrationForm, IHMSPatientBusinessModel>{
	
	private ObjectFactory<IHMSPatientBusinessModel> patientFactory;
	
	@Autowired
	public void setPatientFactory(ObjectFactory<IHMSPatientBusinessModel> patientFactory) {
		this.patientFactory = patientFactory;
	}

	@Override
	public IHMSPatientBusinessModel convert(IRegistrationForm source) {
		IHMSPatientBusinessModel patient = patientFactory.getObject();
		copyUtils(source.getHmsUserForm(), patient);
		copyUtils(source.getHmsPatientForm(), patient);
		setFactoryObject(patient);
		return super.convert(source);
	}
}
