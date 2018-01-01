package com.evoke.hms.services;

import java.util.Date;

import org.apache.commons.lang3.Validate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evoke.hms.HmsApplication;
import com.evoke.hms.business.HMSVisitBusinessModel;
import com.evoke.hms.business.IHMSVisitBusinessModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HmsApplication.class)
@WebAppConfiguration
public class PatientServiceITest {
	
	@Autowired
	IPatientService patientSerivce;
	
	@Before
	public void setUp(){
		
	}

	@Test
	public void testCreateVisit(){
		IHMSVisitBusinessModel hmsVisit = new HMSVisitBusinessModel();
		hmsVisit.setPatientId("HMS_O849C0R3B");
		hmsVisit.setBillId(1001);
		hmsVisit.setDoctorId(1001);
		hmsVisit.setTreatmentId(1);
		hmsVisit.setCreatedOn(new Date());
		hmsVisit.setCreatedBy("RAMU");
		patientSerivce.createVisit(hmsVisit);
		Validate.notNull(hmsVisit.getVistSequenceId());
		
	}
	
	

}
