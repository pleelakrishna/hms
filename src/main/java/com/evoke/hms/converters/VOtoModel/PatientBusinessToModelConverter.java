package com.evoke.hms.converters.VOtoModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.dao.IUsersDAO;
import com.evoke.hms.model.HMSUser;
import com.evoke.hms.model.IHMSPatient;
import com.evoke.hms.model.IHMSUser;

@Component
public class PatientBusinessToModelConverter extends HMSAbstractConverter<IHMSPatientBusinessModel, IHMSPatient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientBusinessToModelConverter.class);
	
	private IUsersDAO userDAO;
	
	@Autowired
	public void setUserDAO(IUsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	private ObjectFactory<IHMSPatient> patientModelFactory;

	@Autowired
	public void setPatientModelFactory(ObjectFactory<IHMSPatient> patientModelFactory) {
		this.patientModelFactory = patientModelFactory;
	}

	@Override
	public IHMSPatient convert(IHMSPatientBusinessModel source) {
		int userId = source.getUserId();
		LOGGER.info("Fetching User details for sequenceId: {}", userId);
		IHMSPatient patient = patientModelFactory.getObject();
		IHMSUser hmsUser = userDAO.getUser(userId);
		setFactoryObject(patient);
		copyUtils(source, patient);
		patient.setHmsUser((HMSUser)hmsUser);
		return patient;
	}
}
