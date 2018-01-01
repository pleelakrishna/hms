package com.evoke.hms.model;

public interface IHMSBills extends IBaseModel {
	int getBillId();
	void setBillId(int billId);
	String getBillType();
	void setBillType(String billType);
}
