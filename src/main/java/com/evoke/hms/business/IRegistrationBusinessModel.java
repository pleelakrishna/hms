package com.evoke.hms.business;

 public interface IRegistrationBusinessModel {
	 IHMSUserBusinessModel getHmsUser();
	 void setHmsUser(IHMSUserBusinessModel hmsUser);
	 IHMSPatientBusinessModel getHmsPatient();
	 void setHmsPatient(IHMSPatientBusinessModel hmsPatient);
	 IHMSDoctorBusinessModel getHmsDoctor();
	 void setHmsDoctor(IHMSDoctorBusinessModel hmsDoctor);

}
