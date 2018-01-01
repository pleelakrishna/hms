package com.evoke.hms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.evoke.hms.business.IBillPaymentDetailsBusinessModel;
import com.evoke.hms.business.IDoctorDeparmentsBusinessModel;
import com.evoke.hms.business.IHMSDoctorBusinessModel;
import com.evoke.hms.business.IRegistrationBusinessModel;
import com.evoke.hms.business.ITreatmentsBusinessModel;
import com.evoke.hms.converters.DepartmentModelToBusinessConverter;
import com.evoke.hms.converters.TreatmentModelToVOConverter;
import com.evoke.hms.converters.VOtoModel.DoctorVOtoModelConverter;
import com.evoke.hms.dao.IDepartmentDAO;
import com.evoke.hms.dao.IDoctorDAO;
import com.evoke.hms.dao.IPatientDAO;
import com.evoke.hms.dao.ITreatmentDAO;
import com.evoke.hms.model.IDoctorDeparments;
import com.evoke.hms.model.IHMSDoctor;
import com.evoke.hms.model.IHMSPatient;
import com.evoke.hms.model.ITreatments;

@Service
public class AdminServiceImpl implements IAdminService {

	private DepartmentModelToBusinessConverter departmentModelToBusinessConverter;
	private DoctorVOtoModelConverter doctorVOtoModelConverter;
	private TreatmentModelToVOConverter treatmentModelToVOConverter;

	private IDepartmentDAO adminDAO;
	private IDoctorDAO doctorDAO;
	private ITreatmentDAO treatmentDAO;
	private IPatientDAO patientDAO;
	
	@Autowired
	public void setPatientDAO(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Autowired
	public void setTreatmentModelToVOConverter(TreatmentModelToVOConverter treatmentModelToVOConverter) {
		this.treatmentModelToVOConverter = treatmentModelToVOConverter;
	}

	@Autowired
	public void setDoctorVOtoModelConverter(DoctorVOtoModelConverter doctorVOtoModelConverter) {
		this.doctorVOtoModelConverter = doctorVOtoModelConverter;
	}

	@Autowired
	public void setDepartmentModelToBusinessConverter(
			DepartmentModelToBusinessConverter departmentModelToBusinessConverter) {
		this.departmentModelToBusinessConverter = departmentModelToBusinessConverter;
	}


	private ObjectFactory<IDoctorDeparmentsBusinessModel> businessDeptFactory;
	private ObjectFactory<IHMSDoctor> doctorModelFactory;
	private ObjectFactory<ITreatmentsBusinessModel> treatmentVOFactory;

	@Autowired
	public void setTreatmentVOFactory(ObjectFactory<ITreatmentsBusinessModel> treatmentVOFactory) {
		this.treatmentVOFactory = treatmentVOFactory;
	}

	@Autowired
	public void setDoctorModelFactory(ObjectFactory<IHMSDoctor> doctorModelFactory) {
		this.doctorModelFactory = doctorModelFactory;
	}

	@Autowired
	public void setBusinessDeptFactory(ObjectFactory<IDoctorDeparmentsBusinessModel> businessDeptFactory) {
		this.businessDeptFactory = businessDeptFactory;
	}




	@Autowired
	public void setTreatmentDAO(ITreatmentDAO treatmentDAO) {
		this.treatmentDAO = treatmentDAO;
	}

	@Autowired
	public void setDoctorDAO(IDoctorDAO doctorDAO) {
		this.doctorDAO = doctorDAO;
	}

	@Autowired
	public void setAdminDAO(IDepartmentDAO adminDAO) {
		this.adminDAO = adminDAO;
	}


	@Override
	@Transactional
	public void createDoctor(IHMSDoctorBusinessModel doctor) {
		IHMSDoctor doctorModel = doctorModelFactory.getObject();
		doctorVOtoModelConverter.setFactoryObject(doctorModel);
		doctorModel = doctorVOtoModelConverter.convert(doctor);
		doctorDAO.createUser(doctorModel);

	}

	@Override
	public List<IDoctorDeparmentsBusinessModel> getDepartments() {
		List<? extends IDoctorDeparments> depts = adminDAO.getDepartments();
		List<IDoctorDeparmentsBusinessModel> businessDpts = new ArrayList<IDoctorDeparmentsBusinessModel>();
		for (IDoctorDeparments dept : depts) {
			IDoctorDeparmentsBusinessModel businessDept = businessDeptFactory.getObject();
			departmentModelToBusinessConverter.setFactoryObject(businessDept);
			businessDept = departmentModelToBusinessConverter.convert(dept);
			businessDpts.add(businessDept);
		}
		return businessDpts;

	}

	@Override
	public List<ITreatmentsBusinessModel> getTreatments() {
		List<? extends ITreatments> treatments = treatmentDAO.getTreatments();
		List<ITreatmentsBusinessModel> treatmentsVO = new ArrayList<ITreatmentsBusinessModel>();
		for (ITreatments treatment: treatments){
			ITreatmentsBusinessModel treatmentVO = treatmentVOFactory.getObject();
			treatmentModelToVOConverter.setFactoryObject(treatmentVO);
			treatmentVO = treatmentModelToVOConverter.convert(treatment);
			treatmentsVO.add(treatmentVO);
		}
		return treatmentsVO;
	}

	/**
	 * 
	 */
	@Override
	@Transactional
	public void payBill(IBillPaymentDetailsBusinessModel billDetails) {
		ITreatments treatment = treatmentDAO.getTreatment(billDetails.getTreatmentId());
		IHMSPatient patient = patientDAO.getByHMSId(billDetails.getPatientId());
		//Convert billDetails to  Model
		

	}

}
