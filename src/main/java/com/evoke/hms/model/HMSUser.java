package com.evoke.hms.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value = "prototype")
@Table(name = "hms_users")
public class HMSUser extends BaseModel implements IHMSUser {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_sequence_id")
	private int userSequenceId;

	@NaturalId
	@Column(name = "USER_LOGIN_ID")
	private String userLoginId;

	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DATE_OF_BIRTH")
	private Date DOB;

	@Column(name = "GENDER")
	private String gender;
	
	@Column(name="PHONE_NO")
	private String phoneNumber;

	@Column(name = "LAST_LOGIN_DATE")
	private Date lastLoginDate;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "IPADDRESS")
	private String IPAddress;
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	@Override
	public int getUserSequenceId() {
		return userSequenceId;
	}
	@Override
	public void setUserSequenceId(int userSequenceId) {
		this.userSequenceId = userSequenceId;
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

	// Association OneToMany for User to Roles
	@OneToMany(cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "hmsusers_roles", 
	joinColumns = { @JoinColumn(name = "user_sequence_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "app_Role_Id") })
	private Collection<HMSAppGroupRoles> AppGroupRoles;

	public Collection<HMSAppGroupRoles> getAppGroupRoles() {
		return AppGroupRoles;
	}

	public void setAppGroupRoles(Collection<HMSAppGroupRoles> appGroupRoles) {
		AppGroupRoles = appGroupRoles;
	}

}
