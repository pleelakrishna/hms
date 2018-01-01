package com.evoke.hms.forms;

import java.util.Date;
import java.util.List;

public interface IHMSUserForm {
	
	public String getEmail();
	public void setEmail(String email);
	public Date getDOB();
	public void setDOB(Date dOB);
	public String getGender();
	public void setGender(String gender);
	List<Integer> getRolesIds();
	void setRolesIds(List<Integer> rolesIds);
	///////////////////////////////
	String getUserLoginId();
	void setUserLoginId(String userLoginId);
	String getUserPassword();
	void setUserPassword(String userPassword);
	String getFirstName();
	void setFirstName(String firstName);
	String getLastName();
	void setLastName(String lastName);
	Date getPwdLastChangedDate();
	void setPwdLastChangedDate(Date pwdLastChangedDate);
	Date getLastLoginDate();
	void setLastLoginDate(Date lastLoginDate);
	String getStatus();
	void setStatus(String status);
	String getIPAddress();
	void setIPAddress(String iPAddress);
}
