package com.evoke.hms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "hms_billpayment_details")
public class BillPaymentDetails extends BaseModel implements IBillPaymentDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="BILLPAYMENT_ID")	
	private int billPaymentId;

	@Column(name="TREATMENT_ID")
	private int treatmentId;

	@Column(name="VALID_FROM")
	private Timestamp validFrom;

	@Column(name="VALID_TO")
	private Timestamp validTo;

	@Column(name="AMOUNT_PAID")
	private BigDecimal amountPaid;
	
	@ManyToOne
	//@JoinColumn(name="PATIENT_ID", nullable=false, updatable=false)
	private HMSPatient hmsPatient;

	public HMSPatient getHmsPatient() {
		return hmsPatient;
	}
	public void setHmsPatient(HMSPatient hmsPatient) {
		this.hmsPatient = hmsPatient;
	}
	public int getBillPaymentId() {
		return billPaymentId;
	}
	public void setBillPaymentId(int billPaymentId) {
		this.billPaymentId = billPaymentId;
	}
	/*public int getBillTypeId() {
		return billTypeId;
	}
	public void setBillTypeId(int billTypeId) {
		this.billTypeId = billTypeId;
	}*/
	public int getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}
	public Timestamp getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}
	public Timestamp getValidTo() {
		return validTo;
	}
	public void setValidTo(Timestamp validTo) {
		this.validTo = validTo;
	}
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	//Association Billtypes 
	@OneToOne
	@JoinColumn(name="BILLTYPE_ID", unique=true,nullable=false,updatable=false)
	private HMSBills hmsBills;

	public HMSBills getHmsBills() {
		return hmsBills;
	}
	public void setHmsBills(HMSBills hmsBills) {
		this.hmsBills = hmsBills;
	}
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="hmsPatient")


}
