package com.evoke.hms.delegates;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evoke.hms.business.IHMSDoctorBusinessModel;
import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.business.IHMSUserBusinessModel;
import com.evoke.hms.business.IRegistrationBusinessModel;
import com.evoke.hms.services.IAdminService;
import com.evoke.hms.services.IPatientService;
import com.evoke.hms.services.IUserService;




@Service
public class RegistrationDelegate implements IRegistrationDeletegate {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationDelegate.class);
	private ObjectFactory<IHMSUserBusinessModel> userVOFactory;
	private ObjectFactory<IHMSDoctorBusinessModel> doctorVOFactory;

	@Autowired
	public void setDoctorVOFactory(ObjectFactory<IHMSDoctorBusinessModel> doctorVOFactory) {
		this.doctorVOFactory = doctorVOFactory;
	}

	@Autowired
	public void setUserFactory(ObjectFactory<IHMSUserBusinessModel> userVOFactory) {
		this.userVOFactory = userVOFactory;
	}

	private IAdminService adminService;
	private IPatientService patientSerivce;
	private IUserService userService;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setPatientSerivce(IPatientService patientSerivce) {
		this.patientSerivce = patientSerivce;
	}

	@Autowired
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	private ObjectFactory<IHMSPatientBusinessModel> patientBusinessFactory;

	@Autowired
	public void setPatientBusinessFactory(ObjectFactory<IHMSPatientBusinessModel> patientBusinessFactory) {
		this.patientBusinessFactory = patientBusinessFactory;
	}

	@Override
	@Transactional
	public void createNewUser(IRegistrationBusinessModel registration) {
		//Need to call three services
		IHMSUserBusinessModel userDetails = userVOFactory.getObject(); 
		IHMSDoctorBusinessModel doctor = doctorVOFactory.getObject();
		IHMSPatientBusinessModel patient =patientBusinessFactory.getObject();
		userDetails = registration.getHmsUser();
		Validate.notNull(userDetails);
		LOGGER.info("RoleId's::{}", userDetails.getRolesIds());
		List<Integer> roleIds =userDetails.getRolesIds(); 
		int departmentId = registration.getHmsDoctor().getDepartmentId();
		doctor = registration.getHmsDoctor();
		int userId = userService.createNewUser(userDetails);
		LOGGER.info("userid::{} value", userId);
		if(roleIds.contains(2)){
			patient = registration.getHmsPatient();
			patient.setUserId(userId);
			patientSerivce.createNewPatient(patient);
		}
		if(departmentId >0 && roleIds.contains(3)){
			doctor.setUserId(userId);
			adminService.createDoctor(doctor);
		}
	}
}
