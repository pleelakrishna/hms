package com.evoke.hms.forms;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class HMSVisitForm implements IHMSVisitForm {

	private int vistSequenceId;
	private String doctorSequenceId;
	private Date dateOfVisit;
	private int treatmentId;
	private String purpose;
	private int billId;
	private String patientId;
	
	private int scheduledFollowups;
	private int scheduleDays;
	
	public int getScheduledFollowups() {
		return scheduledFollowups;
	}

	public void setScheduledFollowups(int scheduledFollowups) {
		this.scheduledFollowups = scheduledFollowups;
	}

	public int getScheduleDays() {
		return scheduleDays;
	}

	public void setScheduleDays(int scheduleDays) {
		this.scheduleDays = scheduleDays;
	}

	
	

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public int getVistSequenceId() {
		return vistSequenceId;
	}

	public void setVistSequenceId(int vistSequenceId) {
		this.vistSequenceId = vistSequenceId;
	}

	public String getDoctorSequenceId() {
		return doctorSequenceId;
	}

	public void setDoctorSequenceId(String doctorSequenceId) {
		this.doctorSequenceId = doctorSequenceId;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}


}
