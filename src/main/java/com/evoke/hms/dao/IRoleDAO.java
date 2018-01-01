package com.evoke.hms.dao;

import java.util.Collection;
import java.util.List;

import com.evoke.hms.model.HMSAppGroupRoles;
import com.evoke.hms.model.IHMSAppGroupRoles;

public interface IRoleDAO extends IGenericDAO<HMSAppGroupRoles> {
	List<HMSAppGroupRoles> get();
	IHMSAppGroupRoles getRoleObject(int id);
	Collection<IHMSAppGroupRoles> getRolesByIds(Collection<Integer> roleIds);
	
}
