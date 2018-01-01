package com.evoke.hms.business;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class HMSAppRolesBusinessModel extends GenericBusinessModel implements IHMSAppRolesBusinessModel, java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private int AppRoleId;
	private String AppRolesName;
	
	public int getAppRoleId() {
		return AppRoleId;
	}

	public void setAppRoleId(int appRoleId) {
		AppRoleId = appRoleId;
	}
	
	public String getAppRolesName() {
		return AppRolesName;
	}

	public void setAppRolesName(String appRolesName) {
		AppRolesName = appRolesName;
	}
}
