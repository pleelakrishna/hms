package com.evoke.hms.dao.impl;

import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.IDoctorDAO;
import com.evoke.hms.model.HMSDoctor;
import com.evoke.hms.model.IHMSDoctor;

@Repository
public class DoctorDAOImpl extends GenericDaoImpl<HMSDoctor> implements IDoctorDAO {

	@Override
	public void createUser(IHMSDoctor doctor) {
		saveOrUpdate((HMSDoctor)doctor);
	}
}
