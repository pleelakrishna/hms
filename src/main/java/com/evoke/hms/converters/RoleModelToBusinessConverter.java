package com.evoke.hms.converters;

import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSAppGroupRolesBusinessModel;
import com.evoke.hms.model.IHMSAppGroupRoles;

@Component
public class RoleModelToBusinessConverter extends HMSAbstractConverter<IHMSAppGroupRoles, IHMSAppGroupRolesBusinessModel>{
	@Override
	public IHMSAppGroupRolesBusinessModel convert(IHMSAppGroupRoles source) {
		return super.convert(source);
	}
}
