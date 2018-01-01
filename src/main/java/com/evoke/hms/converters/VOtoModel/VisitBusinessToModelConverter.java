package com.evoke.hms.converters.VOtoModel;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.business.IHMSVisitBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.exceptions.UserNotFoundException;
import com.evoke.hms.model.HMSPatient;
import com.evoke.hms.model.IHMSPatient;
import com.evoke.hms.model.IHMSVisit;
import com.evoke.hms.services.IPatientService;

@Component
public class VisitBusinessToModelConverter extends HMSAbstractConverter<IHMSVisitBusinessModel, IHMSVisit> {
	
	private ObjectFactory<IHMSVisit> visitModelFactory;
	private ObjectFactory<IHMSPatient> hmsPatientFactory;
	
	private IPatientService patientService;
	
	private ObjectFactory<IHMSPatientBusinessModel> hmsPatientVOFactory;

	@Autowired
	public void setHmsPatientVOFactory(ObjectFactory<IHMSPatientBusinessModel> hmsPatientVOFactory) {
		this.hmsPatientVOFactory = hmsPatientVOFactory;
	}
	
	@Autowired
	public void setPatientService(IPatientService patientService) {
		this.patientService = patientService;
	}
	
	@Autowired
	public void setHmsPatientFactory(ObjectFactory<IHMSPatient> hmsPatientFactory) {
		this.hmsPatientFactory = hmsPatientFactory;
	}

	private PatientBusinessToModelConverter patientBusinessToModelConverter;
	
	@Autowired
	public void setPatientBusinessToModelConverter(PatientBusinessToModelConverter patientBusinessToModelConverter) {
		this.patientBusinessToModelConverter = patientBusinessToModelConverter;
	}

	@Autowired
	public void setVisitModel(ObjectFactory<IHMSVisit> visitModelFactory) {
		this.visitModelFactory = visitModelFactory;
	}
	
	@Override
	public IHMSVisit convert(IHMSVisitBusinessModel source) {
		IHMSPatientBusinessModel hmsPatientVO = hmsPatientVOFactory.getObject();
		try {
			hmsPatientVO =	patientService.findByHMSId(source.getPatientId());
			IHMSVisit hmsVisit = visitModelFactory.getObject();
			IHMSPatient hmsPatient = hmsPatientFactory.getObject();
			patientBusinessToModelConverter.setFactoryObject(hmsPatient);
			hmsPatient = patientBusinessToModelConverter.convert(hmsPatientVO);
			hmsVisit.setHmsPatient((HMSPatient)hmsPatient);
			setFactoryObject(hmsVisit);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return super.convert(source);
	}
	
}
