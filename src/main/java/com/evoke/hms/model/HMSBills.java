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
@Table(name = "hms_bills_lkp")
public class HMSBills extends BaseModel implements IHMSBills,Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="BILL_ID")
	private int billId;
	
	@Column(name="BILL_TYPE")
	private String billType;
		
	@Override
	public int getBillId() {
		return billId;
	}
	@Override
	public void setBillId(int billId) {
		this.billId = billId;
	}
	@Override
	public String getBillType() {
		return billType;
	}
	@Override
	public void setBillType(String billType) {
		this.billType = billType;
	}
	

}
