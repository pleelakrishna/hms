package com.evoke.hms.forms;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class HMSPayBillForm implements IHMSPayBillForm {
	private String patientId;
	private Date validFrom;
	private Date validTo;
	private int treatmentId;
	private BigDecimal amountPaid;
	//To check multi select functionality
	private List<Integer> treatmentIdList;
	
	public List<Integer> getTreatmentIdList() {
		return treatmentIdList;
	}
	public void setTreatmentIdList(List<Integer> treatmentIdList) {
		this.treatmentIdList = treatmentIdList;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public int getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

}
