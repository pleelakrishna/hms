package com.evoke.hms.forms;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

 public interface IHMSPayBillForm {
	 String getPatientId();
	 void setPatientId(String patientId);
	 Date getValidFrom();
	 void setValidFrom(Date validFrom);
	 Date getValidTo();
	 void setValidTo(Date validTo);
	 int getTreatmentId();
	 void setTreatmentId(int treatmentId);
	 BigDecimal getAmountPaid();
	 void setAmountPaid(BigDecimal amountPaid);
	List<Integer> getTreatmentIdList();
	void setTreatmentIdList(List<Integer> treatmentIdList);

}
