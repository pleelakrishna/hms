package com.evoke.hms.converters.VOtoModel;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IBillPaymentDetailsBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.dao.IPatientDAO;
import com.evoke.hms.dao.ITreatmentDAO;
import com.evoke.hms.model.IBillPaymentDetails;
import com.evoke.hms.model.IHMSPatient;
import com.evoke.hms.model.ITreatments;

@Component
public class BillPaymentVOtoModelConverter extends HMSAbstractConverter<IBillPaymentDetailsBusinessModel, IBillPaymentDetails> {
	private ITreatmentDAO treatmentDAO;
	private IPatientDAO patientDAO;
	//private ObjectFactory<T>
	
	@Autowired
	public void setPatientDAO(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Autowired
	public void setTreatmentDAO(ITreatmentDAO treatmentDAO) {
		this.treatmentDAO = treatmentDAO;
	}
	
	@Override
	public IBillPaymentDetails convert(IBillPaymentDetailsBusinessModel source) {
		ITreatments treatment = treatmentDAO.getTreatment(source.getTreatmentId());
		IHMSPatient patient = patientDAO.findByHMSId(source.getPatientId());
		
		return super.convert(source);
	}
}
