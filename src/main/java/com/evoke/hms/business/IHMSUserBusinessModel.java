package com.evoke.hms.business;

import java.util.Date;
import java.util.List;
import java.util.Collection;


public interface IHMSUserBusinessModel extends IGenericBusinessModel {
	int getUserSequenceId();
	void setUserSequenceId(int userSequenceId);
	List<Integer> getRolesIds();
	void setRolesIds(List<Integer> rolesIds);
	String getUserLoginId();
	void setUserLoginId(String userLoginId);
	String getUserPassword();
	void setUserPassword(String userPassword);
	String getFirstName();
	void setFirstName(String firstName);
	String getLastName();
	void setLastName(String lastName);
	String getEmail();
	void setEmail(String email);
	Date getDOB();
	void setDOB(Date dOB);
	String getGender();
	void setGender(String gender);
	Date getCreatedOn();
	void setCreatedOn(Date createdOn);
	Date getPwdLastChangedDate();
	void setPwdLastChangedDate(Date pwdLastChangedDate);
	Date getLastLoginDate();
	void setLastLoginDate(Date lastLoginDate);
	int getFailedLoginCount();
	void setFailedLoginCount(int failedLoginCount);
	int getAppUserGroupId();
	void setAppUserGroupId(int appUserGroupId);
	String getCreatedBy();
	void setCreatedBy(String createdBy);
	String getStatus();
	void setStatus(String status);
	String getIPAddress();
	void setIPAddress(String iPAddress);
	Collection<HMSAppGroupRolesBusinesModel> getAppGroupRoles();
	void setAppGroupRoles(Collection<HMSAppGroupRolesBusinesModel> appGroupRoles);

}
