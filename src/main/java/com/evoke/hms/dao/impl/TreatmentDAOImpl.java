package com.evoke.hms.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.ITreatmentDAO;
import com.evoke.hms.model.ITreatments;
import com.evoke.hms.model.Treatments;

@Repository
public class TreatmentDAOImpl extends GenericDaoImpl<Treatments> implements ITreatmentDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(TreatmentDAOImpl.class);
	@Override
	public List<? extends ITreatments> getTreatments() {
		List<? extends ITreatments> treatments = get();
		LOGGER.info("Hibernate cache mode:: {}", getSession().getCacheMode());
		LOGGER.info("Second level cache hit count:: {}", getSession().getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
		return treatments;
	}

	@Override
	public ITreatments getTreatment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
