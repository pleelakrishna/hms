package com.evoke.hms.business;

import java.util.Date;

public interface IGenericBusinessModel {

	Date getLastModifiedOn();
	void setLastModifiedOn(Date lastModifiedOn);
	String getLastModifiedBy();
	void setLastModifiedBy(String lastModifiedBy);
	String getCreatedBy();
	void setCreatedBy(String createdBy);
	Date getCreatedOn();
	void setCreatedOn(Date createdOn);

}
