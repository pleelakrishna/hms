package com.evoke.hms.model;

import java.util.Date;

public interface IBaseModel {

	Date getLastModifiedOn();
	void setLastModifiedOn(Date lastModifiedOn);
	String getLastModifiedBy();
	void setLastModifiedBy(String lastModifiedBy);
	String getCreatedBy();
	void setCreatedBy(String createdBy);
	Date getCreatedOn();
	void setCreatedOn(Date createdOn);

}
