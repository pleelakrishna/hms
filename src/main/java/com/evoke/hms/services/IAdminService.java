package com.evoke.hms.services;

import java.util.List;

import com.evoke.hms.business.IBillPaymentDetailsBusinessModel;
import com.evoke.hms.business.IDoctorDeparmentsBusinessModel;
import com.evoke.hms.business.IHMSDoctorBusinessModel;
import com.evoke.hms.business.ITreatmentsBusinessModel;

public interface IAdminService {
	void createDoctor(IHMSDoctorBusinessModel doctor);
	List<IDoctorDeparmentsBusinessModel> getDepartments();
	List<ITreatmentsBusinessModel> getTreatments(); 
	void payBill(IBillPaymentDetailsBusinessModel billDetails);
}
