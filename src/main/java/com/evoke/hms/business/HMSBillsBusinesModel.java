package com.evoke.hms.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class HMSBillsBusinesModel extends GenericBusinessModel implements IHMSBillsBusinessModel,Serializable {
	
	private static final long serialVersionUID = 1L;

	private int billId;
	
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
