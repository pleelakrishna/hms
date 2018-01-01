package com.evoke.hms.forms;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="prototype")
public class HMSDoctorForm implements IHMSDoctorForm{

	private static final long serialVersionUID = 1L;
	
	private int doctorId;
	
	private int departmentId;
	
	private String qualification;
	private int userId;
	
	@Override
	public int getUserId() {
		return userId;
	}
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int getDoctorId() {
		return doctorId;
	}

	@Override
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
	public String getQualification() {
		return qualification;
	}

	@Override
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
}
