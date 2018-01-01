package com.evoke.hms.converters.VOtoModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSDoctorBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.dao.IUsersDAO;
import com.evoke.hms.dao.impl.DepartmentDAOImpl;
import com.evoke.hms.model.DoctorDepartments;
import com.evoke.hms.model.HMSUser;
import com.evoke.hms.model.IDoctorDeparments;
import com.evoke.hms.model.IHMSDoctor;
import com.evoke.hms.model.IHMSUser;

@Component
public class DoctorVOtoModelConverter extends HMSAbstractConverter<IHMSDoctorBusinessModel, IHMSDoctor>{
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorVOtoModelConverter.class);

	private DepartmentDAOImpl departmentDAO;
	private ObjectFactory<IHMSDoctor> doctorFactory;

	private IUsersDAO userDAO;

	@Autowired
	public void setUserDAO(IUsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	public void setDoctorFactory(ObjectFactory<IHMSDoctor> doctorFactory) {
		this.doctorFactory = doctorFactory;
	}

	@Autowired
	public void setDepartmentDAO(DepartmentDAOImpl departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@Override
	public IHMSDoctor convert(IHMSDoctorBusinessModel source) {
		IDoctorDeparments department = departmentDAO.getDepartment(source.getDepartmentId());
		IHMSDoctor doctor = doctorFactory.getObject();
		int userId = source.getUserId();
		LOGGER.info("Fetching User details for sequenceId: {}", userId);
		IHMSUser hmsUser = userDAO.getUser(userId);
		setFactoryObject(doctor);
		copyUtils(source, doctor);
		doctor.setHmsUser((HMSUser)hmsUser);
		doctor.setDoctorDepartment((DoctorDepartments)department);
		return doctor;
	}
}
