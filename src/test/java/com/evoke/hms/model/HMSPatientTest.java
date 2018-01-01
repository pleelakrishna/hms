package com.evoke.hms.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class HMSPatientTest {

	private HMSPatient hmsPatient;
	private HMSUser hmsUser;

	@Before
	public void setUp(){
		hmsPatient = new HMSPatient();
		hmsUser = new HMSUser();

	}

	@Test
	public void TestGetPatientId(){
		ReflectionTestUtils.setField(hmsPatient, "patientId", 1005);
		Assert.assertEquals(hmsPatient.getPatientId(), 1005);
	}

	@Test
	public void TestSetPatientId(){
		int patientId = 1005;
		hmsPatient.setPatientId(patientId);
		Assert.assertEquals(patientId, ReflectionTestUtils.getField(hmsPatient, "patientId"));
	}

	@Test
	public void TestGetHmsUniqueId(){
		ReflectionTestUtils.setField(hmsPatient, "hmsUniqueId", "HMSQWER1052");
		Assert.assertEquals(hmsPatient.getHmsUniqueId(), "HMSQWER1052");

	}

	@Test
	public void TestSetHmsUniqueId(){
		String hmsUniqueId = "HMSQWER1052";
		hmsPatient.setHmsUniqueId(hmsUniqueId);
		Assert.assertEquals(hmsUniqueId, ReflectionTestUtils.getField(hmsPatient, "hmsUniqueId"));

	}

	@Test
	public void TestGetEmergencyContactName(){
		ReflectionTestUtils.setField(hmsPatient, "emergencyContactName", "RAMU");
		Assert.assertEquals(hmsPatient.getEmergencyContactName(), "RAMU");

	}

	@Test
	public void TestSetEmergencyContactName(){
		String name = "RAMU";
		hmsPatient.setEmergencyContactName(name);
		Assert.assertEquals(name, ReflectionTestUtils.getField(hmsPatient, "emergencyContactName"));
	}

	@Test
	public void TestGetEmergencyContactNumber(){
		ReflectionTestUtils.setField(hmsPatient, "emergencyContactNumber", "9030225995");
		Assert.assertEquals(hmsPatient.getEmergencyContactNumber(), "9030225995");

	}

	@Test
	public void TestSetEmergencyContactNumber(){
		String contactNumber = "9030225995";
		hmsPatient.setEmergencyContactNumber(contactNumber);
		Assert.assertEquals(contactNumber, ReflectionTestUtils.getField(hmsPatient, "emergencyContactNumber"));

	}

	@Test
	public void TestGetMaritalStatus(){
		ReflectionTestUtils.setField(hmsPatient, "maritalStatus", "SINGLE");
		Assert.assertEquals(hmsPatient.getMaritalStatus(), "SINGLE");
	}

	@Test
	public void TestSetMaritalStatus(){
		String maritalStatus = "SINGLE";
		hmsPatient.setMaritalStatus(maritalStatus);
		Assert.assertEquals(maritalStatus, ReflectionTestUtils.getField(hmsPatient, "maritalStatus"));

	}

	@Test
	public void TestGetBloodGroup(){
		ReflectionTestUtils.setField(hmsPatient, "bloodGroup", "O+");
		Assert.assertEquals(hmsPatient.getBloodGroup(), "O+");

	}

	@Test
	public void TestSetBloodGroup(){
		String bloodGroup = "O+";
		hmsPatient.setBloodGroup(bloodGroup);
		Assert.assertEquals(bloodGroup, ReflectionTestUtils.getField(hmsPatient, "bloodGroup"));

	}

	@Test
	public void TestGetAllergicTo(){
		ReflectionTestUtils.setField(hmsPatient, "allergicTo", "Pencilin");
		Assert.assertEquals(hmsPatient.getAllergicTo(), "Pencilin");
	}

	@Test
	public void TestSetAllergicTo(){
		String allericTo = "pencilin";
		hmsPatient.setAllergicTo(allericTo);
		Assert.assertEquals(allericTo, ReflectionTestUtils.getField(hmsPatient, "allergicTo"));
	}

	@Test
	public void TestGetBloodPressure(){
		ReflectionTestUtils.setField(hmsPatient, "bloodPressure", false);
		Assert.assertEquals(hmsPatient.getBloodPressure(), false);

	}

	@Test
	public void TestSetBloodPressure(){
		hmsPatient.setBloodPressure(false);
		Assert.assertEquals(false, ReflectionTestUtils.getField(hmsPatient, "bloodPressure"));
	}

	@Test
	public void TestGetDiabetes(){
		ReflectionTestUtils.setField(hmsPatient, "diabetes", false);
		Assert.assertEquals(hmsPatient.getDiabetes(), false);

	}

	@Test
	public void TestSetDiabetes(){
		hmsPatient.setDiabetes(false);
		Assert.assertEquals(false, ReflectionTestUtils.getField(hmsPatient, "diabetes"));

	}

	@Test
	public void TestGetSmoking(){
		ReflectionTestUtils.setField(hmsPatient, "smoking", false);
		Assert.assertEquals(hmsPatient.getSmoking(), false);

	}

	@Test
	public void TestSetSmoking(){
		hmsPatient.setSmoking(false);
		Assert.assertEquals(false, ReflectionTestUtils.getField(hmsPatient, "smoking"));

	}

	@Test
	public void TestGetAlcoholic(){
		ReflectionTestUtils.setField(hmsPatient, "alcoholic", false);
		Assert.assertEquals(hmsPatient.getAlcoholic(), false);

	}

	@Test
	public void TestSetAlcoholic(){
		hmsPatient.setAlcoholic(false);
		Assert.assertEquals(false, ReflectionTestUtils.getField(hmsPatient, "alcoholic"));
	}

	@Test
	public void TestGetPreviousSurgeryDetails(){
		ReflectionTestUtils.setField(hmsPatient, "previousSurgeryDetails", "Test surgery");
		Assert.assertEquals(hmsPatient.getPreviousSurgeryDetails(), "Test surgery");

	}

	@Test
	public void TestSetPreviousSurgeryDetails(){
		String previousSurgeryDetails = "Test Surgery";
		hmsPatient.setPreviousSurgeryDetails(previousSurgeryDetails);
		Assert.assertEquals(previousSurgeryDetails, ReflectionTestUtils.getField(hmsPatient, "previousSurgeryDetails"));

	}

	@Test
	public void TestGetHmsUser(){
		ReflectionTestUtils.setField(hmsPatient, "hmsUser", hmsUser);
		Assert.assertEquals(hmsPatient.getHmsUser(), hmsUser);
	}

	@Test
	public void TestSetHmsUser(){
		hmsPatient.setHmsUser(hmsUser);
		Assert.assertEquals(hmsUser, ReflectionTestUtils.getField(hmsPatient, "hmsUser"));

	}

}
