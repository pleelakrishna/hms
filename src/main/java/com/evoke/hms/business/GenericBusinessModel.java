package com.evoke.hms.business;

import java.util.Date;

/**
 * Generic Model contains common columns in all tables 
 * @author rpasupuleti
 *
 */

public abstract class GenericBusinessModel implements IGenericBusinessModel {
	
	private Date lastModifiedOn;
	
	private String lastModifiedBy;
	
	private Date createdOn;
	
	private String createdBy;
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}
	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
