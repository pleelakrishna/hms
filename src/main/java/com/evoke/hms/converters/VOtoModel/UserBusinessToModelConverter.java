package com.evoke.hms.converters.VOtoModel;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSUserBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.dao.IRoleDAO;
import com.evoke.hms.model.HMSAppGroupRoles;
import com.evoke.hms.model.IHMSAppGroupRoles;
import com.evoke.hms.model.IHMSUser;

@Component
public class UserBusinessToModelConverter extends HMSAbstractConverter<IHMSUserBusinessModel, IHMSUser>{

	private ObjectFactory<IHMSUser> userModelFactory;
	
	private IRoleDAO roleDAO;

	@Autowired
	public void setRoleDAO(IRoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Autowired
	public void setUserModelFactory(ObjectFactory<IHMSUser> userModelFactory) {
		this.userModelFactory = userModelFactory;
	}

	@Override
	public IHMSUser convert(IHMSUserBusinessModel source) {
		//Setting appGroupRoles from list of Roles
		List<Integer> roleIds = source.getRolesIds();
		IHMSUser hmsUser = userModelFactory.getObject();
		Collection<? extends IHMSAppGroupRoles> roles = roleDAO.getRolesByIds(roleIds);
		setFactoryObject(hmsUser);
		copyUtils(source, hmsUser);
		hmsUser.setAppGroupRoles((Collection<HMSAppGroupRoles>) roles);
		return hmsUser;
	}
}
