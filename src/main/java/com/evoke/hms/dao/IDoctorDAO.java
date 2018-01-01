package com.evoke.hms.dao;

import com.evoke.hms.model.HMSDoctor;
import com.evoke.hms.model.IHMSDoctor;

public interface IDoctorDAO extends IGenericDAO<HMSDoctor> {
	
	void createUser(IHMSDoctor doctor);

}
