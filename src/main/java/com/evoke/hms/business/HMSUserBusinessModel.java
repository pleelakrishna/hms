package com.evoke.hms.business;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Primary
@Component(value="HMSUserBusinessObject")
@Scope(value="prototype")
public class HMSUserBusinessModel extends GenericBusinessModel implements java.io.Serializable,IHMSUserBusinessModel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userSequenceId;

	private String userLoginId;

	private String userPassword;

	private Date pwdLastChangedDate;

	private Date lastLoginDate;

	private int failedLoginCount;

	private int appUserGroupId;

	private String status;

	private String IPAddress;
	private String firstName;
	private String lastName;

	private String email;
	private Date DOB;
	private String gender;
	private List<Integer> rolesIds;

	public int getUserSequenceId() {
		return userSequenceId;
	}
	public void setUserSequenceId(int userSequenceId) {
		this.userSequenceId = userSequenceId;
	}
	
	public List<Integer> getRolesIds() {
		return rolesIds;
	}
	public void setRolesIds(List<Integer> rolesIds) {
		this.rolesIds = rolesIds;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getPwdLastChangedDate() {
		return pwdLastChangedDate;
	}
	public void setPwdLastChangedDate(Date pwdLastChangedDate) {
		this.pwdLastChangedDate = pwdLastChangedDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public int getFailedLoginCount() {
		return failedLoginCount;
	}
	public void setFailedLoginCount(int failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}
	public int getAppUserGroupId() {
		return appUserGroupId;
	}
	public void setAppUserGroupId(int appUserGroupId) {
		this.appUserGroupId = appUserGroupId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}

	private Collection<HMSAppGroupRolesBusinesModel> AppGroupRoles;

	public Collection<HMSAppGroupRolesBusinesModel> getAppGroupRoles() {
		return AppGroupRoles;
	}
	public void setAppGroupRoles(Collection<HMSAppGroupRolesBusinesModel> appGroupRoles) {
		AppGroupRoles = appGroupRoles;
	}

}
