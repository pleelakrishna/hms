package com.evoke.hms.forms;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class HMSUserForm implements java.io.Serializable,IHMSUserForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Size(min=5, max = 30, message="Size must be between 5 and 30 characters")
	private String userLoginId;

	@Size(min = 6, max = 15, message = "Password must between 6 and 15 characters")
	private String userPassword;

	private Date pwdLastChangedDate;
	private Date lastLoginDate;
	private String status;
	private String IPAddress;
	@Size(min=5, max = 30, message="Size must be between 5 and 30 characters")
	private String firstName;
	@Size(min=5, max = 30, message="Size must be between 5 and 30 characters")
	private String lastName;
	
	@Email(message="Please enter valid email id")
	private String email;
	
	@Past(message="Date of Birth should be less than system date")
	private Date DOB;
	private String gender;
	
	//RoleId's
	private List<Integer> rolesIds;
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
	public List<Integer> getRolesIds() {
		return rolesIds;
	}
	@Override
	public void setRolesIds(List<Integer> rolesIds) {
		this.rolesIds = rolesIds;
	}
	@Override
	public String getUserLoginId() {
		return userLoginId;
	}
	@Override
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	@Override
	public String getUserPassword() {
		return userPassword;
	}
	@Override
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public Date getPwdLastChangedDate() {
		return pwdLastChangedDate;
	}
	@Override
	public void setPwdLastChangedDate(Date pwdLastChangedDate) {
		this.pwdLastChangedDate = pwdLastChangedDate;
	}
	@Override
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	@Override
	public String getStatus() {
		return status;
	}
	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String getIPAddress() {
		return IPAddress;
	}
	@Override
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
