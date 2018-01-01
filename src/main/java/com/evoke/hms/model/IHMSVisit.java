package com.evoke.hms.model;

import java.util.Date;

public interface IHMSVisit extends IBaseModel {
	int getVistSequenceId();
	void setVistSequenceId(int vistSequenceId);
	int getDoctorId();
	void setDoctorId(int doctorId);
	Date getDateOfVisit();
	void setDateOfVisit(Date dateOfVisit);
	int getTreatmentId();
	void setTreatmentId(int treatmentId);
	String getPurpose();
	void setPurpose(String purpose);
	int getBillId();
	void setBillId(int billId);
	HMSPatient getHmsPatient();
	void setHmsPatient(HMSPatient hmsPatient);
}
