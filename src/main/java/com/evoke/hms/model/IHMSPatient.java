package com.evoke.hms.model;

import java.util.Collection;

public interface IHMSPatient extends IBaseModel {
	int getPatientId();
	void setPatientId(int patientId);
	String getHmsUniqueId();
	void setHmsUniqueId(String hmsUniqueId);
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
	HMSUser getHmsUser();
	void setHmsUser(HMSUser hmsUser);
	Collection<BillPaymentDetails> getPatientBillDetails();
	void setPatientBillDetails(Collection<BillPaymentDetails> patientBillDetails);

}
