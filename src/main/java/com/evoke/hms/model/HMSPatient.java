package com.evoke.hms.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "hms_patient")
public class HMSPatient extends BaseModel implements IHMSPatient {
	
	private static final long serialVersionUID = 13L;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="PATIENT_ID", unique = true, nullable=false)
	private int patientId;
	
	@NaturalId
	@Column(name="HMS_UNIQUE_ID", unique = true, nullable=false)
	private String hmsUniqueId;
	
	@Column(name="EMERGENCY_CONTACT_NAME")
	private String emergencyContactName;
	
	@Column(name="EMERGENCY_CONTACT_PHONE")
	private String emergencyContactNumber;
	
	@Column(name="MARITAL_STATUS")
	private String maritalStatus;
	
	@Column(name="BLOOD_GROUP")
	private String bloodGroup;
	
	@Column(name="ALLERGIC_TO")
	private String allergicTo;
	
	@Column(name="BLOOD_PRESSURE")
	private Boolean bloodPressure;
	
	@Column(name="DIABETES")
	private Boolean diabetes;
	
	@Column(name="SMOKING")
	private Boolean smoking;
	
	@Column(name="ALOCHOLIC")
	private Boolean alcoholic;
	
	@Column(name="PREVIOUS_SURGERY_DETAILS")
	private String previousSurgeryDetails;
	
	@Override
	public int getPatientId() {
		return patientId;
	}
	@Override
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@Override
	public String getHmsUniqueId() {
		return hmsUniqueId;
	}
	@Override
	public void setHmsUniqueId(String hmsUniqueId) {
		this.hmsUniqueId = hmsUniqueId;
	}
	@Override
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	@Override
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	@Override
	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}
	@Override
	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}
	@Override
	public String getMaritalStatus() {
		return maritalStatus;
	}
	@Override
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	@Override
	public String getBloodGroup() {
		return bloodGroup;
	}
	@Override
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	@Override
	public String getAllergicTo() {
		return allergicTo;
	}
	@Override
	public void setAllergicTo(String allergicTo) {
		this.allergicTo = allergicTo;
	}
	@Override
	public Boolean getBloodPressure() {
		return bloodPressure;
	}
	@Override
	public void setBloodPressure(Boolean bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	@Override
	public Boolean getDiabetes() {
		return diabetes;
	}
	@Override
	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}
	@Override
	public Boolean getSmoking() {
		return smoking;
	}
	@Override
	public void setSmoking(Boolean smoking) {
		this.smoking = smoking;
	}
	@Override
	public Boolean getAlcoholic() {
		return alcoholic;
	}
	@Override
	public void setAlcoholic(Boolean alcoholic) {
		this.alcoholic = alcoholic;
	}
	@Override
	public String getPreviousSurgeryDetails() {
		return previousSurgeryDetails;
	}
	@Override
	public void setPreviousSurgeryDetails(String previousSurgeryDetails) {
		this.previousSurgeryDetails = previousSurgeryDetails;
	}
	
	//Patient to user Association
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "USER_ID")
	 private HMSUser hmsUser;

	public HMSUser getHmsUser() {
		return hmsUser;
	}

	public void setHmsUser(HMSUser hmsUser) {
		this.hmsUser = hmsUser;
	}
	
	
	//Patient to Bills
	@OneToMany(cascade = CascadeType.ALL, mappedBy="hmsPatient")
	@Fetch(FetchMode.SUBSELECT)
	private Collection<BillPaymentDetails> patientBillDetails;

	public Collection<BillPaymentDetails> getPatientBillDetails() {
		return patientBillDetails;
	}
	public void setPatientBillDetails(Collection<BillPaymentDetails> patientBillDetails) {
		this.patientBillDetails = patientBillDetails;
	}
	
	
}
