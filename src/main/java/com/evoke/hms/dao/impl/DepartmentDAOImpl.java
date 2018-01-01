package com.evoke.hms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.IDepartmentDAO;
import com.evoke.hms.model.DoctorDepartments;
import com.evoke.hms.model.IDoctorDeparments;

@Repository
public class DepartmentDAOImpl extends GenericDaoImpl<DoctorDepartments> implements IDepartmentDAO {

	@Override
	public List<DoctorDepartments> getDepartments() {
		return get();
	}

	@Override
	public IDoctorDeparments getDepartment(int id) {
		return load(id);
	}

}
