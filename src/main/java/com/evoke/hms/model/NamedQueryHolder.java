package com.evoke.hms.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
    @NamedNativeQuery(
    		name="HMSUser.findUser", 
    		query="SELECT * FROM hms_users p where p.user_sequence_id =:userSequenceId",
    		resultClass=HMSUser.class
    		)
})
public class NamedQueryHolder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;

}
