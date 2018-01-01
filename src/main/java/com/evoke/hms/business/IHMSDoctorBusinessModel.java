package com.evoke.hms.business;

public interface IHMSDoctorBusinessModel extends IGenericBusinessModel {
	int getDoctorId();
	void setDoctorId(int doctorId);
	int getUserId();
	void setUserId(int userId);
	int getDepartmentId();
	void setDepartmentId(int departmentId);
	String getQualification();
	void setQualification(String qualification);

}
