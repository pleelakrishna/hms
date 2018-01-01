package com.evoke.hms.model;

public interface IHMSDoctor extends IBaseModel {
	int getDepartmentId();
	void setDepartmentId(int departmentId);
	String getQualification();
	void setQualification(String qualification);
	DoctorDepartments getDoctorDepartment();
	void setDoctorDepartment(DoctorDepartments doctorDepartment);
	HMSUser getHmsUser();
	void setHmsUser(HMSUser hmsUser);

}
