package com.evoke.hms.model;

public interface IDoctorDeparments extends IBaseModel {
	public int getDepartmentId();
	public void setDepartmentId(int departmentId);
	public String getDepartmentName();
	public void setDepartmentName(String departmentName);
	public String getDescription();
	public void setDescription(String description);
}
