package com.evoke.hms.forms;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class HMSPatientForm implements IHMSPatientForm {
	private int patientId;
	private int userId;
	private String hmsUniqueId;
	private String email;
	private Date DOB;
	private String gender;
	private String phoneNumber;
	private String emergencyContactName;
	private String emergencyContactNumber;
	private String maritalStatus;
	private String bloodGroup;
	private String allergicTo;
	private Boolean bloodPressure;
	private Boolean diabetes;
	private Boolean smoking;
	private Boolean alcoholic;
	private String previousSurgeryDetails;
	private int departmentId;
	
	@Override
	public int getPatientId() {
		return patientId;
	}
	@Override
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public Date getDOB() {
		return DOB;
	}
	@Override
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	@Override
	public String getGender() {
		return gender;
	}
	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int getDepartmentId() {
		return departmentId;
	}
	@Override
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public int getUserId() {
		return userId;
	}
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

}
