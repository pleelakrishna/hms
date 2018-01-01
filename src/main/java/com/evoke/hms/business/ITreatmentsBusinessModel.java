package com.evoke.hms.business;

public interface ITreatmentsBusinessModel extends IGenericBusinessModel {
	int getTreatmentId();
	void setTreatmentId(int treatmentId);
	String getTreatmentName();
	void setTreatmentName(String treatmentName);
}
