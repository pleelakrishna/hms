package com.evoke.hms.dao;

import java.util.List;

import com.evoke.hms.model.HMSBills;
import com.evoke.hms.model.IHMSBills;

public interface IBillDAO extends IGenericDAO<HMSBills> {
	List<HMSBills> getBillTypes();
	IHMSBills getDepartment(int id);

}
