package com.evoke.hms.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.IVisitDAO;
import com.evoke.hms.model.HMSVisit;
import com.evoke.hms.model.IHMSVisit;

@Repository
public class VisitDAOImpl extends GenericDaoImpl<HMSVisit> implements IVisitDAO{
	private static final Logger LOGGER = LoggerFactory.getLogger(VisitDAOImpl.class);

	@Override
	public void createVisit(IHMSVisit hmsVisit) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Date date = new Date();
		hmsVisit.setCreatedOn(date);
		hmsVisit.setCreatedBy(name);
		hmsVisit.setLastModifiedBy(name);
		hmsVisit.setLastModifiedOn(date);
		saveOrUpdate((HMSVisit)hmsVisit);		
	}
	
	
	@Override
	public List<? extends IHMSVisit> getVisits() {
		LOGGER.info("Hibernate cache mode:: {}", getSession().getCacheMode());
		LOGGER.info("Second level cache hit count:: {}", getSession().getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
		List<? extends IHMSVisit> visits = get();
		return visits; //Generic methods which returns list of HMSVisit Objects
	}

	@Override
	public IHMSVisit getVisit(int id) {
		return load(id);
	}

	@Override
	public void updateVisit(IHMSVisit hmsVisit) {
		update((HMSVisit)hmsVisit);
	}

	@Override
	public void deleteVisit(IHMSVisit hmsVisit) {
		delete((HMSVisit)hmsVisit);
	}
	
}
