package com.evoke.hms.converters;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.HMSAppGroupRolesBusinesModel;
import com.evoke.hms.business.IHMSAppGroupRolesBusinessModel;
import com.evoke.hms.business.IHMSUserBusinessModel;
import com.evoke.hms.model.IHMSAppGroupRoles;
import com.evoke.hms.model.IHMSUser;

@Component
public class UserModelToBusinessConverter extends HMSAbstractConverter<IHMSUser, IHMSUserBusinessModel> {
	
	private HMSAppRolesModelToBusinessConverter hmsAppRolesModelToBusinessConverter;
	
	private ObjectFactory<IHMSUserBusinessModel> userBusinessFactory;
	
	@Autowired
	public void setUserBusinessFactory(ObjectFactory<IHMSUserBusinessModel> userBusinessFactory) {
		this.userBusinessFactory = userBusinessFactory;
	}

	private ObjectFactory<IHMSAppGroupRolesBusinessModel> hmsBusinessRolesFactory;
	
	@Autowired
	public void setHmsBusinessRolesFactory(ObjectFactory<IHMSAppGroupRolesBusinessModel> hmsBusinessRolesFactory) {
		this.hmsBusinessRolesFactory = hmsBusinessRolesFactory;
	}

	@Autowired
	public void setHmsAppRolesModelToBusinessConverter(
			HMSAppRolesModelToBusinessConverter hmsAppRolesModelToBusinessConverter) {
		this.hmsAppRolesModelToBusinessConverter = hmsAppRolesModelToBusinessConverter;
	}
	
	@Override
	public IHMSUserBusinessModel convert(IHMSUser source) {
		Iterator<? extends IHMSAppGroupRoles> itr = source.getAppGroupRoles().iterator();
		Set<HMSAppGroupRolesBusinesModel> businessRolesList = new HashSet<HMSAppGroupRolesBusinesModel>();
		
		//Dealing with App Group Roles from one-to-many
		while(itr.hasNext()){
			//HMSBusinessAppGroupRoles roleObject = new HMSBusinessAppGroupRoles(); 
			IHMSAppGroupRolesBusinessModel roleObject = hmsBusinessRolesFactory.getObject(); 
			hmsAppRolesModelToBusinessConverter.setFactoryObject(roleObject);
			roleObject = hmsAppRolesModelToBusinessConverter.convert(itr.next());
			businessRolesList.add((HMSAppGroupRolesBusinesModel) roleObject);
		}
		IHMSUserBusinessModel userBusiness = userBusinessFactory.getObject();
		setFactoryObject(userBusiness);
		copyUtils(source, userBusiness);
		userBusiness.setAppGroupRoles(businessRolesList);
		return userBusiness;
	}
}
