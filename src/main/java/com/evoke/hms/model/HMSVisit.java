package com.evoke.hms.model;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "hms_visit")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) 
public class HMSVisit extends BaseModel implements java.io.Serializable,IHMSVisit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="VISIT_SEQUENCE_ID",nullable=false)
	private int vistSequenceId;

	@Column(name = "DOCTOR_SEQUENCE_ID")
	private int doctorId;

	@Column(name = "DATE_OF_VISIT")
	private Date dateOfVisit;

	@Column(name = "TREATMENT_ID")
	private int treatmentId;

	@Column(name = "PURPOSE")
	private String purpose;

	@Column(name = "BILL_ID")
	private int billId;
	
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

	
	@ManyToOne
	@JoinColumn(name = "PATIENT_ID")
	private HMSPatient hmsPatient;

	public HMSPatient getHmsPatient() {
		return hmsPatient;
	}

	public void setHmsPatient(HMSPatient hmsPatient) {
		this.hmsPatient = hmsPatient;
	}

	//OneToMany with Treatment details
	
	
	
}
