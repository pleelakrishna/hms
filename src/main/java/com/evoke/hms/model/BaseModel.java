package com.evoke.hms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Generic Model contains common columns in all tables 
 * @author rpasupuleti
 *
 */

@MappedSuperclass
public abstract class BaseModel implements IBaseModel {
	
	@Column(name = "Last_Modified_On")
	private Date lastModifiedOn;
	
	@Column(name = "Last_Modified_by")
	private String lastModifiedBy;
	
	@Column(name = "Created_On")
	private Date createdOn;
	
	@Column(name = "Created_By")
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
