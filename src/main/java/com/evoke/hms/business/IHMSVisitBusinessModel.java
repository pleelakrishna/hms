package com.evoke.hms.business;

import java.util.Date;

public interface IHMSVisitBusinessModel extends IGenericBusinessModel {
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
	String getPatientId();
	void setPatientId(String patientId);
	int getScheduledFollowups();
	void setScheduledFollowups(int scheduledFollowups);
	int getScheduleDays();
	
}
