package com.evoke.hms.forms;

import java.util.Date;

public interface IGenericForm {
	Date getLastModifiedOn();
	void setLastModifiedOn(Date lastModifiedOn);
	String getLastModifiedBy();
	void setLastModifiedBy(String lastModifiedBy);
	String getCreatedBy();
	void setCreatedBy(String createdBy);
	Date getCreatedOn();
	void setCreatedOn(Date createdOn);

}
