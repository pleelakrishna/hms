package com.evoke.hms.dao;

import java.util.List;

import com.evoke.hms.model.DoctorDepartments;
import com.evoke.hms.model.IDoctorDeparments;

public interface IDepartmentDAO extends IGenericDAO<DoctorDepartments> {
	List<DoctorDepartments> getDepartments();
	IDoctorDeparments getDepartment(int id);
}
