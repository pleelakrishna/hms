package com.evoke.hms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "hms_doctor")
public class HMSDoctor extends BaseModel implements IHMSDoctor{

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="DOCTOR_ID", unique = true, nullable=false)
	private int doctorId;

	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	
	@Column(name="QUALIFICATION")
	private String qualification;
	

	@Override
	public int getDepartmentId() {
		return departmentId;
	}
	
	@Override
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	@Override
	public String getQualification() {
		return qualification;
	}

	@Override
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	
	//Association: Doctor to User Association
	@OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "USER_ID")
	 private HMSUser hmsUser;

	public HMSUser getHmsUser() {
		return hmsUser;
	}

	public void setHmsUser(HMSUser hmsUser) {
		this.hmsUser = hmsUser;
	}
	
	//Association Doctor to Doctordepartment
	@OneToOne
    @PrimaryKeyJoinColumn
	private DoctorDepartments doctorDepartment;

	public DoctorDepartments getDoctorDepartment() {
		return doctorDepartment;
	}

	public void setDoctorDepartment(DoctorDepartments doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}
}
