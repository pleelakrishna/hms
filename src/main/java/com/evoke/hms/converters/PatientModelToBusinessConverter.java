package com.evoke.hms.converters;



import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.model.IHMSPatient;

@Component
public class PatientModelToBusinessConverter extends HMSAbstractConverter<IHMSPatient, IHMSPatientBusinessModel>{

	private ObjectFactory<IHMSPatientBusinessModel> patientFactory;

	@Autowired
	public void setPatientFactory(ObjectFactory<IHMSPatientBusinessModel> patientFactory) {
		this.patientFactory = patientFactory;
	}

	@Override
	public IHMSPatientBusinessModel convert(IHMSPatient source) {
		//Convert roles from model To Business
		//Check userId is not coming
		IHMSPatientBusinessModel patientVO = patientFactory.getObject();
		patientVO.setUserId(source.getPatientId());
		setFactoryObject(patientVO);
		return super.convert(source);
	}

}
