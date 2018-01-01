package com.evoke.hms.business;

public interface IHMSBillsBusinessModel extends IGenericBusinessModel {
	int getBillId();
	void setBillId(int billId);
	String getBillType();
	void setBillType(String billType);
}
