package com.evoke.hms.forms;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSVisitBusinessModel;



@Component
@Scope(value="prototype")
public class ManageVisitsForm implements IManageVisitsForm {
	
	private String patientId;
	private String doctorId;
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	private Date dateOfVisit;
	
	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	private List<IHMSVisitBusinessModel> hmsVisits;

	public List<IHMSVisitBusinessModel> getHmsVisits() {
		return hmsVisits;
	}

	public void setHmsVisits(List<IHMSVisitBusinessModel> hmsVisits) {
		this.hmsVisits = hmsVisits;
	}

	
	
	
}
