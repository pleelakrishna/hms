package com.evoke.hms.converters.FormToVO;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSVisitBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.forms.IHMSVisitForm;
import com.evoke.hms.services.IPatientService;

@Component
public class VisitFormToBusinessConverter extends HMSAbstractConverter<IHMSVisitForm, IHMSVisitBusinessModel> {
	
	private IPatientService patientService;
	private ObjectFactory<IHMSVisitBusinessModel> hmsVisitFactory;

	@Autowired
	public void setHmsVisitFactory(ObjectFactory<IHMSVisitBusinessModel> hmsVisitFactory) {
		this.hmsVisitFactory = hmsVisitFactory;
	}

	@Autowired
	public void setPatientService(IPatientService patientService) {
		this.patientService = patientService;
	}
	
	@Override
	public IHMSVisitBusinessModel convert(IHMSVisitForm source) {
		/*try{
			IHMSPatientVO hmsPatient = patientService.findByHMSId(source.getPatientId());
			IHMSVisitVO hmsVisit = hmsVisitFactory.getObject();
			hmsVisit.setHmsPatient((HMSPatientVO)hmsPatient);
			setFactoryObject(hmsVisit);
		}catch (UserNotFoundException e){
			e.printStackTrace();
		}*/
		return super.convert(source);
	}	
	

}
