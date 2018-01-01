package com.evoke.hms.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface IBillPaymentDetails extends IBaseModel {
	int getBillPaymentId();
	void setBillPaymentId(int billPaymentId);
/*	int getBillTypeId();
	void setBillTypeId(int billTypeId);*/
	int getTreatmentId();
	void setTreatmentId(int treatmentId);
	Timestamp getValidFrom();
	void setValidFrom(Timestamp validFrom);
	Timestamp getValidTo();
	void setValidTo(Timestamp validTo);
	BigDecimal getAmountPaid();
	void setAmountPaid(BigDecimal amountPaid);
	HMSBills getHmsBills();
	void setHmsBills(HMSBills hmsBills);

}
