package com.evoke.hms.business;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="HMSVisitBusinessObject")
@Scope(value="prototype")
public class HMSVisitBusinessModel extends GenericBusinessModel implements java.io.Serializable,IHMSVisitBusinessModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int vistSequenceId;

	private int doctorId;

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

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	/*private HMSPatientVO hmsPatient;

	public HMSPatientVO getHmsPatient() {
		return hmsPatient;
	}

	public void setHmsPatient(HMSPatientVO hmsPatient) {
		this.hmsPatient = hmsPatient;
	}*/
	
}
