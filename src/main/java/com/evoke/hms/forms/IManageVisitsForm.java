package com.evoke.hms.forms;

import java.util.Date;
import java.util.List;

import com.evoke.hms.business.IHMSVisitBusinessModel;



public interface IManageVisitsForm {
	String getPatientId();
	void setPatientId(String patientId);
	String getDoctorId();
	void setDoctorId(String doctorId);
	Date getDateOfVisit();
	void setDateOfVisit(Date dateOfVisit);
	public List<IHMSVisitBusinessModel> getHmsVisits();
	public void setHmsVisits(List<IHMSVisitBusinessModel> hmsVisits);

}
