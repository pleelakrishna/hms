package com.evoke.hms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "hms_app_group_roles")
public class HMSAppGroupRoles extends BaseModel implements IHMSAppGroupRoles, Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "app_role_Id")
	private int appRoleId;
	
	@Column(name = "app_roles_name")
	private String appRolesName;

	public int getAppRoleId() {
		return appRoleId;
	}

	public void setAppRoleId(int appRoleId) {
		this.appRoleId = appRoleId;
	}

	public String getAppRolesName() {
		return appRolesName;
	}

	public void setAppRolesName(String appRolesName) {
		this.appRolesName = appRolesName;
	}
	
}
