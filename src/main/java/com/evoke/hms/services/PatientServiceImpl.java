package com.evoke.hms.services;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.business.IHMSVisitBusinessModel;
import com.evoke.hms.converters.PatientModelToBusinessConverter;
import com.evoke.hms.converters.VisitModelToBusinessConverter;
import com.evoke.hms.converters.VOtoModel.PatientBusinessToModelConverter;
import com.evoke.hms.converters.VOtoModel.VisitBusinessToModelConverter;
import com.evoke.hms.dao.IPatientDAO;
import com.evoke.hms.dao.IVisitDAO;
import com.evoke.hms.model.IHMSPatient;
import com.evoke.hms.model.IHMSVisit;


/**
 * Patient related service class deals with CRUD operations for Patient data
 * @author rpasupuleti
 *
 */
@Service
public class PatientServiceImpl implements IPatientService{

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

	private IPatientDAO patientDAO;
	private IVisitDAO visitDAO;

	//DTO's
	private ObjectFactory<IHMSPatientBusinessModel> hmsPatientFactory;
	private ObjectFactory<IHMSPatient> hmsPatientModelFactory;
	private ObjectFactory<IHMSVisit> visitModelFactory;
	private ObjectFactory<IHMSVisitBusinessModel> visitBusinessFactory;

	//Converters
	private PatientModelToBusinessConverter patientModelToBusinessConverter;
	private PatientBusinessToModelConverter patientBusinessToModelConverter;
	private VisitBusinessToModelConverter visitBussinessToModelConverter;
	private VisitModelToBusinessConverter visitModelToBusinessConverter;

	@Autowired
	public void setVisitBusinessFactory(ObjectFactory<IHMSVisitBusinessModel> visitBusinessFactory) {
		this.visitBusinessFactory = visitBusinessFactory;
	}

	@Autowired
	public void setVisitModelToBusinessConverter(VisitModelToBusinessConverter visitModelToBusinessConverter) {
		this.visitModelToBusinessConverter = visitModelToBusinessConverter;
	}

	@Autowired
	public void setVisitModelFactory(ObjectFactory<IHMSVisit> visitModelFactory) {
		this.visitModelFactory = visitModelFactory;
	}

	@Autowired
	public void setVisitBussinessToModelConverter(VisitBusinessToModelConverter visitBussinessToModelConverter) {
		this.visitBussinessToModelConverter = visitBussinessToModelConverter;
	}


	@Autowired
	public void setHmsPatientModelFactory(ObjectFactory<IHMSPatient> hmsPatientModelFactory) {
		this.hmsPatientModelFactory = hmsPatientModelFactory;
	}

	@Autowired
	public void setHmsPatientFactory(ObjectFactory<IHMSPatientBusinessModel> hmsPatientFactory) {
		this.hmsPatientFactory = hmsPatientFactory;
	}
	@Autowired
	public void setPatientBusinessToModelConverter(PatientBusinessToModelConverter patientBusinessToModelConverter) {
		this.patientBusinessToModelConverter = patientBusinessToModelConverter;
	}



	@Autowired
	public void setPatientModelToBusinessConverter(PatientModelToBusinessConverter patientModelToBusinessConverter) {
		this.patientModelToBusinessConverter = patientModelToBusinessConverter;
	}


	@Autowired
	public void setVisitDAO(IVisitDAO visitDAO) {
		this.visitDAO = visitDAO;
	}


	@Autowired
	public void setPatientDAO(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}


	@Override
	@Transactional
	public void createNewPatient(IHMSPatientBusinessModel patient) {
		IHMSPatient patientModel = hmsPatientModelFactory.getObject();
		patientBusinessToModelConverter.setFactoryObject(patientModel);
		patientModel = patientBusinessToModelConverter.convert(patient);
		patientDAO.createNewPatient(patientModel);
	}

	@Override
	public IHMSPatientBusinessModel findByHMSId(String hmsId) {
		Validate.notBlank(hmsId,"HMS ID Must not be Blank");

		LOGGER.debug("Fetching userdetails for username: {}", hmsId);
		IHMSPatientBusinessModel hmsPatient = hmsPatientFactory.getObject();
		patientModelToBusinessConverter.setFactoryObject(hmsPatient);
		//Model to Business Converter
		hmsPatient = patientModelToBusinessConverter.convert(patientDAO.findByHMSId(hmsId));
		if(hmsPatient==null) {
			LOGGER.error("Invalid HMS ID:: {}",hmsId);
		} 
		return hmsPatient;
	}

	@Transactional
	public void updateUserDetails(IHMSPatientBusinessModel hmsPatient) {
		Validate.notNull(hmsPatient);
		//Business to Model Converter
		IHMSPatient hmsPatientModel = hmsPatientModelFactory.getObject();
		patientBusinessToModelConverter.setFactoryObject(hmsPatientModel);
		hmsPatientModel = patientBusinessToModelConverter.convert(hmsPatient);
		patientDAO.updateUserDetails(hmsPatientModel);
	}

	@Transactional
	public void deleteProfile(String hmsId) {
		LOGGER.debug("Started deleting profile for HMSID: {}",hmsId);
		IHMSPatient hmsPatient = patientDAO.findByHMSId(hmsId);
		Validate.notNull(hmsPatient);
		//	hmsPatient.getHmsUser().setAppGroupRoles(null);
		patientDAO.deleteProfile(hmsPatient);
		//LOGGER.debug("Successfully deleted User profile for userSequenceId: {}",hmsPatient.get());
	}

	@Override
	@Transactional
	public void createVisit(IHMSVisitBusinessModel hmsVisit) {
	
		if(hmsVisit.getScheduledFollowups()!=0){
			Calendar cal = Calendar.getInstance();
			cal.setTime(hmsVisit.getDateOfVisit());
			int noOfVisits = hmsVisit.getScheduledFollowups(); 
			int daysGap = hmsVisit.getScheduleDays();
			for(int i=1; i < noOfVisits;i++){  
				IHMSVisit hmsVisitModel = visitModelFactory.getObject();
				visitBussinessToModelConverter.setFactoryObject(hmsVisitModel);
				hmsVisitModel = visitBussinessToModelConverter.convert(hmsVisit);
				cal.add(Calendar.DAY_OF_MONTH, (i-1)*daysGap);
				LOGGER.info("Date of Visit:{}",cal.getTime());
				hmsVisitModel.setDateOfVisit(cal.getTime());
				visitDAO.createVisit(hmsVisitModel);
				if(i % 5 == 0){
					visitDAO.flushSession();
					visitDAO.clearSession();
				}
			}
		}else{
			IHMSVisit hmsVisitModel = visitModelFactory.getObject();
			visitBussinessToModelConverter.setFactoryObject(hmsVisitModel);
			hmsVisitModel = visitBussinessToModelConverter.convert(hmsVisit);
			visitDAO.createVisit(hmsVisitModel);
		}
	}


	@Override
	public List<IHMSVisitBusinessModel> getVisits() {
		//ModelToBusinessConverter
		List<IHMSVisitBusinessModel> visitList = new ArrayList<IHMSVisitBusinessModel>();
		//Iterating over list of visits and converting to Business list
		for (IHMSVisit model: visitDAO.getVisits()){
			IHMSVisitBusinessModel visit = visitBusinessFactory.getObject();
			visitModelToBusinessConverter.setFactoryObject(visit);
			visitList.add(visitModelToBusinessConverter.convert(model));
		}
		return visitList;
	}

	@Override
	public IHMSVisitBusinessModel getVisit(int id) {
		//ModelToBusinessConverter
		IHMSVisitBusinessModel visit = visitBusinessFactory.getObject();
		visitModelToBusinessConverter.setFactoryObject(visit);
		return visitModelToBusinessConverter.convert(visitDAO.getVisit(id));
	}


	@Override
	@Transactional
	public void editVisit(IHMSVisitBusinessModel hmsVisit) {
		IHMSVisit hmsVisitModel = visitModelFactory.getObject();
		visitBussinessToModelConverter.setFactoryObject(hmsVisitModel);
		visitDAO.updateVisit(visitBussinessToModelConverter.convert(hmsVisit));

	}


	@Override
	@Transactional
	public void deleteVisit(int id) {
		visitDAO.deleteVisit(visitDAO.getVisit(id));
	}

}
