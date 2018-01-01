package com.evoke.hms.dao;

import java.util.List;

import com.evoke.hms.model.HMSVisit;
import com.evoke.hms.model.IHMSVisit;

public interface IVisitDAO extends IGenericDAO<HMSVisit> {
	
	void createVisit(IHMSVisit ihmsVisit);
	List<? extends IHMSVisit> getVisits();
	IHMSVisit getVisit(int id);
	void updateVisit(IHMSVisit hmsVisit);
	void deleteVisit(IHMSVisit hmsVisit);
	void clearSession();
}
