package com.evoke.hms.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.IRoleDAO;
import com.evoke.hms.model.HMSAppGroupRoles;
import com.evoke.hms.model.IHMSAppGroupRoles;

@Repository
public class RoleDAOImpl extends GenericDaoImpl<HMSAppGroupRoles> implements IRoleDAO {

	@Override
	public List<HMSAppGroupRoles> get() {
		return super.get();
	}

	@Override
	public IHMSAppGroupRoles getRoleObject(int id) {
		Validate.notNull(id);
		return get(id);
	}

	@Override
	public Collection<IHMSAppGroupRoles> getRolesByIds(Collection<Integer> roleIds) {
		Collection<IHMSAppGroupRoles> roles = new ArrayList<IHMSAppGroupRoles>();
		try{
			Criteria crit = getCriteria();
			crit.add(Restrictions.in("appRoleId", roleIds));
			roles = new ArrayList<IHMSAppGroupRoles> (crit.list());
		}catch(HibernateException he){
			he.printStackTrace();
			//Throw Exception here
		}
		return roles;
	}

}
