package com.evoke.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "hms_treatment_lkp")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY) 
public class Treatments extends BaseModel implements ITreatments {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "TREATMENT_ID", unique = true, nullable = false)
	private int treatmentId;
	
	@Column(name = "TREATMENT_NAME", unique = true, nullable = false)
	private String treatmentName;
	
	public int getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}
	public String getTreatmentName() {
		return treatmentName;
	}
	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}
	
	//ManyToOne to a bill
	@ManyToOne
	@JoinColumn(name = "BILLPAYMENT_ID")
	private BillPaymentDetails BillPaymentDetails;
	
	
}
