package com.evoke.hms.business;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="DoctorDeparmentsVO")
@Scope(value="prototype")
public class DoctorDeparmentsBusinesModel extends GenericBusinessModel implements IDoctorDeparmentsBusinessModel {
	
	private int departmentId;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String departmentName;
	private String description;
	

}
