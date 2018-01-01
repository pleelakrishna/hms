package com.evoke.hms.converters.FormToVO;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSDoctorBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.forms.IRegistrationForm;

@Component
public class RegistrationFormToDoctorVOConverter extends HMSAbstractConverter<IRegistrationForm, IHMSDoctorBusinessModel>{
	
	private ObjectFactory<IHMSDoctorBusinessModel> doctorFactory;
	
	@Autowired
	public void setDoctorFactory(ObjectFactory<IHMSDoctorBusinessModel> doctorFactory) {
		this.doctorFactory = doctorFactory;
	}
	
	@Override
	public IHMSDoctorBusinessModel convert(IRegistrationForm source) {
		IHMSDoctorBusinessModel doctor = doctorFactory.getObject();
		copyUtils(source.getHmsUserForm(), doctor);
		copyUtils(source.getHmsDoctorForm(), doctor);
		setFactoryObject(doctor);
		return super.convert(source);
	}
}
