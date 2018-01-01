package com.evoke.hms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.IBillDAO;
import com.evoke.hms.model.HMSBills;
import com.evoke.hms.model.IHMSBills;

@Repository
public class BillDAOImpl extends GenericDaoImpl<HMSBills> implements IBillDAO {

	@Override
	public List<HMSBills> getBillTypes() {
		return get();
	}

	@Override
	public IHMSBills getDepartment(int id) {
		return get(id);
	}

}
