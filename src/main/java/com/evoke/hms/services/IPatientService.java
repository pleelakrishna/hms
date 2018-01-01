package com.evoke.hms.services;

import java.util.List;

import org.springframework.beans.factory.ObjectFactory;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.business.IHMSVisitBusinessModel;
import com.evoke.hms.converters.PatientModelToBusinessConverter;
import com.evoke.hms.converters.VisitModelToBusinessConverter;
import com.evoke.hms.converters.VOtoModel.PatientBusinessToModelConverter;
import com.evoke.hms.converters.VOtoModel.VisitBusinessToModelConverter;
import com.evoke.hms.dao.IPatientDAO;
import com.evoke.hms.dao.IVisitDAO;
import com.evoke.hms.exceptions.UserNotFoundException;
import com.evoke.hms.model.IHMSPatient;
import com.evoke.hms.model.IHMSVisit;


public interface IPatientService {
	void createNewPatient(IHMSPatientBusinessModel patient);
	IHMSPatientBusinessModel findByHMSId(String hmsId) throws UserNotFoundException;
	void updateUserDetails(IHMSPatientBusinessModel hmsPatient) throws UserNotFoundException;
	void deleteProfile(String hmsId) throws UserNotFoundException;
	void createVisit(IHMSVisitBusinessModel hmsVisit);
	List<IHMSVisitBusinessModel> getVisits();
	IHMSVisitBusinessModel getVisit(int id);
	void editVisit(IHMSVisitBusinessModel hmsVisit);
	void deleteVisit(int id);
	void setVisitBusinessFactory(ObjectFactory<IHMSVisitBusinessModel> visitBusinessFactory);
	void setVisitModelToBusinessConverter(VisitModelToBusinessConverter visitModelToBusinessConverter);
	void setVisitModelFactory(ObjectFactory<IHMSVisit> visitModelFactory);
	void setVisitBussinessToModelConverter(VisitBusinessToModelConverter visitBussinessToModelConverter);
	void setHmsPatientModelFactory(ObjectFactory<IHMSPatient> hmsPatientModelFactory);
	void setHmsPatientFactory(ObjectFactory<IHMSPatientBusinessModel> hmsPatientFactory);
	void setPatientBusinessToModelConverter(PatientBusinessToModelConverter patientBusinessToModelConverter);
	void setPatientModelToBusinessConverter(PatientModelToBusinessConverter patientModelToBusinessConverter);
	void setVisitDAO(IVisitDAO visitDAO);
	void setPatientDAO(IPatientDAO patientDAO);
}
