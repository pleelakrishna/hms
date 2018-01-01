package com.evoke.hms.dao;

import com.evoke.hms.model.HMSPatient;
import com.evoke.hms.model.IHMSPatient;

public interface IPatientDAO extends IGenericDAO<HMSPatient> {
	void createNewPatient(IHMSPatient hmsPatient);
	IHMSPatient findByHMSId(String hmsId);
	void updateUserDetails(IHMSPatient hmsPatient);
	void deleteProfile(IHMSPatient hmsPatient);
}
