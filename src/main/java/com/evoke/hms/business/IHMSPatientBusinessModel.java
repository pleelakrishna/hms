package com.evoke.hms.business;

import java.util.Date;


public interface IHMSPatientBusinessModel extends IGenericBusinessModel{
	int getPatientId();
	void setPatientId(int patientId);
	String getHmsUniqueId();
	void setHmsUniqueId(String hmsUniqueId);
	String getEmail();
	void setEmail(String email);
	Date getDOB();
	void setDOB(Date dOB);
	String getGender();
	void setGender(String gender);
	int getDepartmentId();
	void setDepartmentId(int departmentId);
	int getUserId();
	void setUserId(int userId);
	String getPhoneNumber();
	void setPhoneNumber(String phoneNumber);
	String getEmergencyContactName();
	void setEmergencyContactName(String emergencyContactName);
	String getEmergencyContactNumber();
	void setEmergencyContactNumber(String emergencyContactNumber);
	String getMaritalStatus();
	void setMaritalStatus(String maritalStatus);
	String getBloodGroup();
	void setBloodGroup(String bloodGroup);
	String getAllergicTo();
	void setAllergicTo(String allergicTo);
	Boolean getBloodPressure();
	void setBloodPressure(Boolean bloodPressure);
	Boolean getDiabetes();
	void setDiabetes(Boolean diabetes);
	Boolean getSmoking();
	void setSmoking(Boolean smoking);
	Boolean getAlcoholic();
	void setAlcoholic(Boolean alcoholic);
	String getPreviousSurgeryDetails();
	void setPreviousSurgeryDetails(String previousSurgeryDetails);
}
