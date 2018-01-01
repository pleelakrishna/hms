package com.evoke.hms.dao.impl;

import java.util.Date;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.IUsersDAO;
import com.evoke.hms.model.HMSUser;
import com.evoke.hms.model.IHMSUser;

@Repository
public class UsersDAOImpl extends GenericDaoImpl<HMSUser> implements IUsersDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsersDAOImpl.class);

	@Override
	public HMSUser findByUsername(String username) {
		LOGGER.debug("In findByUsername for username {}", username);
		return getByNaturalId(username);
	}

	@Override
	public void createNewUser(IHMSUser hmsUser) {
			String loginId = hmsUser.getUserLoginId();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			LOGGER.debug("Started creating new user with loginId: {} and created by {}", loginId, name);
			Date date = new Date();
			hmsUser.setStatus("ACTIVE");
			hmsUser.setLastModifiedOn(date);
			hmsUser.setLastLoginDate(date);
			hmsUser.setLastModifiedBy(name);
			saveOrUpdate((HMSUser)hmsUser);
	}

	/**
	 * Using Namednative query for test
	 */
	@Override
	public IHMSUser getUser(int id) {
		LOGGER.debug("In getUser calling nameQuery with id {}", id);
		Query query = getSession().getNamedQuery("HMSUser.findUser").setInteger("userSequenceId", id);
		HMSUser user = (HMSUser) query.uniqueResult(); 
		return user;
	}

}
