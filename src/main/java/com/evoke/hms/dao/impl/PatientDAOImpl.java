package com.evoke.hms.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.IPatientDAO;
import com.evoke.hms.model.HMSPatient;
import com.evoke.hms.model.IHMSPatient;
import com.evoke.hms.util.HMSUtil;

@Repository
public class PatientDAOImpl extends GenericDaoImpl<HMSPatient> implements IPatientDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientDAOImpl.class);
	HMSUtil hmsUtil;
	
	@Autowired 
	public void setHmsUtil(HMSUtil hmsUtil) {
		this.hmsUtil = hmsUtil;
	}

	@Override
	public void createNewPatient(IHMSPatient hmsPatient) {
			String hmsId = hmsUtil.GenerateEHRID();
			String givenName = hmsPatient.getHmsUser().getFirstName();
			LOGGER.debug("In createNewPatient for hmsId: {} and userName: {}", hmsId, givenName);
			hmsPatient.setHmsUniqueId(hmsId);
			saveOrUpdate((HMSPatient)hmsPatient); //Generic DAO saves the object
			LOGGER.debug("Successfully created patient details for hmsId: {} and userName: {}", hmsId, givenName);
	}

	@Override
	public IHMSPatient findByHMSId(String hmsId) {
		LOGGER.debug("Invoked  findByHMSId for hmsId: {}", hmsId);
		return (IHMSPatient) getByNaturalId(hmsId);
	}

	@Override
	public void updateUserDetails(IHMSPatient hmsPatient) {
		LOGGER.debug("Invoked  updateUserDetails for hmsId: {}", hmsPatient.getHmsUniqueId());
		update((HMSPatient)hmsPatient); //Generic method to update the object
	}

	@Override
	public void deleteProfile(IHMSPatient hmsPatient) {
		LOGGER.debug("Invoked  delete user for hmsId: {}", hmsPatient.getHmsUniqueId());
		delete((HMSPatient)hmsPatient); //Generic DAO to delete the object
	}
	
}
