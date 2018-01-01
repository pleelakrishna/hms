package com.evoke.hms.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evoke.hms.business.IHMSAppGroupRolesBusinessModel;
import com.evoke.hms.business.IHMSUserBusinessModel;
import com.evoke.hms.converters.RoleModelToBusinessConverter;
import com.evoke.hms.converters.UserModelToBusinessConverter;
import com.evoke.hms.converters.VOtoModel.UserBusinessToModelConverter;
import com.evoke.hms.dao.IPatientDAO;
import com.evoke.hms.dao.IRoleDAO;
import com.evoke.hms.dao.IUsersDAO;
import com.evoke.hms.model.IHMSUser;


/**
 * User related service class deals with Create and Read operations for User data
 * @author rpasupuleti
 *
 */

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private IUsersDAO usersDAO;

	private IPatientDAO patientDAO;
	private IRoleDAO roleDAO;
	
	@Autowired
	public void setRoleDAO(IRoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	
	private UserModelToBusinessConverter userModelToBusinessConverter;
	
	private RoleModelToBusinessConverter roleModelToBusinessConverter;
	
	private ObjectFactory<IHMSUserBusinessModel> userBusinessFactory;
	
	private ObjectFactory<IHMSUser> userModelFactory;
	
	private UserBusinessToModelConverter userBusinessToModelConverter;
	
	
	@Autowired
	public void setUserBusinessToModelConverter(UserBusinessToModelConverter userBusinessToModelConverter) {
		this.userBusinessToModelConverter = userBusinessToModelConverter;
	}


	@Autowired
	public void setUserModelFactory(ObjectFactory<IHMSUser> userModelFactory) {
		this.userModelFactory = userModelFactory;
	}

	@Autowired
	public void setUserBusinessFactory(ObjectFactory<IHMSUserBusinessModel> userBusinessFactory) {
		this.userBusinessFactory = userBusinessFactory;
	}

	private ObjectFactory<IHMSAppGroupRolesBusinessModel> rolesBusinessFactory;
	
	
	
	@Autowired
	public void setRolesBusinessFactory(ObjectFactory<IHMSAppGroupRolesBusinessModel> rolesBusinessFactory) {
		this.rolesBusinessFactory = rolesBusinessFactory;
	}

	@Autowired
	public void setRoleModelToBusinessConverter(RoleModelToBusinessConverter roleModelToBusinessConverter) {
		this.roleModelToBusinessConverter = roleModelToBusinessConverter;
	}
	
	@Autowired
	public void setUserModelToBusinessConverter(UserModelToBusinessConverter userModelToBusinessConverter) {
		this.userModelToBusinessConverter = userModelToBusinessConverter;
	}

	
	@Autowired
	public void setUsersDAO(IUsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	@Autowired
	public void setPatientDAO(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Transactional
	public int createNewUser(IHMSUserBusinessModel userDetails){
		IHMSUser hmsUser = userModelFactory.getObject();
		userBusinessToModelConverter.setFactoryObject(hmsUser);
		hmsUser= userBusinessToModelConverter.convert(userDetails);
		usersDAO.createNewUser(hmsUser);
		return hmsUser.getUserSequenceId();
	}
	
	@Override
	@Transactional
	public IHMSUserBusinessModel findByUsername(String userName){
		Validate.notBlank(userName,"User Name Must not be Blank");
		LOGGER.debug("Fetching userdetails for username: {}", userName);
		IHMSUserBusinessModel hmsUser = userBusinessFactory.getObject();
		userModelToBusinessConverter.setFactoryObject(hmsUser);
		//Converting Model to business object
		hmsUser = userModelToBusinessConverter.convert(usersDAO.findByUsername(userName));
		return hmsUser;
	}


	@Override
	public List<IHMSAppGroupRolesBusinessModel> getRoles() {
		//Model to Business Converter
		List<IHMSAppGroupRolesBusinessModel> businessRoles = new ArrayList<IHMSAppGroupRolesBusinessModel>();
		List<? extends com.evoke.hms.model.IHMSAppGroupRoles> modelRoles = roleDAO.get();
		for (com.evoke.hms.model.IHMSAppGroupRoles role : modelRoles) {
			IHMSAppGroupRolesBusinessModel businessRole = rolesBusinessFactory.getObject();
			roleModelToBusinessConverter.setFactoryObject(businessRole);
			businessRole = roleModelToBusinessConverter.convert(role);
			businessRoles.add(businessRole);
		}
		return businessRoles;
	}
	
}
