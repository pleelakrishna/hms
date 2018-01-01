package com.evoke.hms.converters;



import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.business.IHMSVisitBusinessModel;
import com.evoke.hms.model.IHMSVisit;

@Component
public class VisitModelToBusinessConverter extends HMSAbstractConverter<IHMSVisit, IHMSVisitBusinessModel> {
	
	private PatientModelToBusinessConverter patientModelToBusinessConverter;
	
	private ObjectFactory<IHMSPatientBusinessModel> patientFactory;
	private ObjectFactory<IHMSVisitBusinessModel> visitBusinessFactory;
	
	@Autowired
	public void setVisitBusinessFactory(ObjectFactory<IHMSVisitBusinessModel> visitBusinessFactory) {
		this.visitBusinessFactory = visitBusinessFactory;
	}

	@Autowired
	public void setPatientFactory(ObjectFactory<IHMSPatientBusinessModel> patientFactory) {
		this.patientFactory = patientFactory;
	}

	@Autowired
	public void setPatientModelToBusinessConverter(PatientModelToBusinessConverter patientModelToBusinessConverter) {
		this.patientModelToBusinessConverter = patientModelToBusinessConverter;
	}

	@Override
	public IHMSVisitBusinessModel convert(IHMSVisit source) {
		//patient model to business converter
		IHMSPatientBusinessModel patient = patientFactory.getObject();
		patientModelToBusinessConverter.setFactoryObject(patient);
		patient = patientModelToBusinessConverter.convert(source.getHmsPatient());
		IHMSVisitBusinessModel visit = visitBusinessFactory.getObject();
		visit.setPatientId(source.getHmsPatient().getHmsUniqueId());
		//visit.setHmsPatient(patient);  ???
		setFactoryObject(visit);
		return super.convert(source);
	}

}
