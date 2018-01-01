package com.evoke.hms.forms;

import java.util.Date;

public interface IHMSVisitForm {
	int getVistSequenceId();
	void setVistSequenceId(int vistSequenceId);
	String getDoctorSequenceId();
	void setDoctorSequenceId(String doctorSequenceId);
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
	void setScheduleDays(int scheduleDays);

}
