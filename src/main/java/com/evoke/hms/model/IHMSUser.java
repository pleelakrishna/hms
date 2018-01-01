package com.evoke.hms.model;

import java.util.Date;
import java.util.Collection;


public interface IHMSUser extends IBaseModel {
	int getUserSequenceId();
	void setUserSequenceId(int userSequenceId);
	String getUserLoginId();
	String getLastName();
	void setLastName(String lastName) ;
	String getFirstName();
	void setFirstName(String firstName);
	String getEmail();
	void setEmail(String email);
	Date getDOB();
	void setDOB(Date dOB);
	String getGender();
	void setGender(String gender);
	String getPhoneNumber();
	void setPhoneNumber(String phoneNumber);
	void setUserLoginId(String userLoginId);
	String getUserPassword();
	void setUserPassword(String userPassword);
	Date getLastLoginDate();
	void setLastLoginDate(Date lastLoginDate);
	String getStatus();
	void setStatus(String status);
	String getIPAddress();
	void setIPAddress(String iPAddress);
	Collection<HMSAppGroupRoles> getAppGroupRoles();
	void setAppGroupRoles(Collection<HMSAppGroupRoles> appGroupRoles);

}
