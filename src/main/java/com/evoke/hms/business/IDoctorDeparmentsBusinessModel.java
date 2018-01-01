package com.evoke.hms.business;

public interface IDoctorDeparmentsBusinessModel extends IGenericBusinessModel {
	 int getDepartmentId();
	 void setDepartmentId(int departmentId);
	 String getDepartmentName();
	 void setDepartmentName(String departmentName);
	 String getDescription();
	 void setDescription(String description);
}
