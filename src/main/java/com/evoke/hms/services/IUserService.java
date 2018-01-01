package com.evoke.hms.services;

import java.util.List;

import com.evoke.hms.business.IHMSAppGroupRolesBusinessModel;
import com.evoke.hms.business.IHMSUserBusinessModel;

public interface IUserService {
	IHMSUserBusinessModel findByUsername(String userName);
	List<IHMSAppGroupRolesBusinessModel> getRoles();
	int createNewUser(IHMSUserBusinessModel userDetails);
}
