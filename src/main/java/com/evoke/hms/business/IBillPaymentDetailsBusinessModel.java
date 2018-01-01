package com.evoke.hms.business;

import java.math.BigDecimal;
import java.util.Date;

public interface IBillPaymentDetailsBusinessModel extends IGenericBusinessModel {
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
}
