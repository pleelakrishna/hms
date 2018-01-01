package com.evoke.hms.dao;

import com.evoke.hms.model.HMSUser;
import com.evoke.hms.model.IHMSUser;

public interface IUsersDAO {
	HMSUser findByUsername(String username);
	void createNewUser(IHMSUser hmsUser);
	IHMSUser getUser(int id);
}
