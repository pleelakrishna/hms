package com.evoke.hms.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class HMSVisitTest {
	private HMSVisit hmsVisit;
	private HMSPatient hmsPatient;

	@Before
	public void setUp() throws Exception{
		hmsVisit = new HMSVisit();
		hmsPatient = new HMSPatient();
	}

	@Test
	public void testGetVistSequenceId(){
		ReflectionTestUtils.setField(hmsVisit, "vistSequenceId", 5);
		Assert.assertEquals(hmsVisit.getVistSequenceId(), 5);
	}
	@Test
	public void testSetVistSequenceId() {
		int sequenceId = 5;
		hmsVisit.setVistSequenceId(sequenceId);
		Assert.assertEquals(sequenceId, ReflectionTestUtils.getField(hmsVisit, "vistSequenceId"));

	}
	@Test
	public void testGetDoctorId() {
		ReflectionTestUtils.setField(hmsVisit, "doctorId", 5);
		Assert.assertEquals(hmsVisit.getDoctorId(), 5);
	}
	@Test
	public void testSetDoctorId() {
		int sequenceId = 5;
		hmsVisit.setDoctorId(sequenceId);
		Assert.assertEquals(sequenceId, ReflectionTestUtils.getField(hmsVisit, "doctorId"));

	}
	@Test
	public void testGetDateOfVisit() {
		Date dateOfVisit = new Date();
		ReflectionTestUtils.setField(hmsVisit, "dateOfVisit", dateOfVisit);
		Assert.assertEquals(hmsVisit.getDateOfVisit(), dateOfVisit);
	}
	@Test
	public void testSetDateOfVisit() {
		Date dateOfVisit = new Date();
		hmsVisit.setDateOfVisit(dateOfVisit);
		Assert.assertEquals(dateOfVisit, ReflectionTestUtils.getField(hmsVisit, "dateOfVisit"));
	}
	@Test
	public void testGetTreatmentId() {
		ReflectionTestUtils.setField(hmsVisit, "treatmentId", 1);
		Assert.assertEquals(hmsVisit.getTreatmentId(), 1);
	}
	@Test
	public void testSetTreatmentId() {
		int treatmentId = 5;
		hmsVisit.setTreatmentId(treatmentId);
		Assert.assertEquals(treatmentId, ReflectionTestUtils.getField(hmsVisit, "treatmentId"));
	}
	@Test
	public void testGetPurpose() {
		ReflectionTestUtils.setField(hmsVisit, "purpose", "test");
		Assert.assertEquals(hmsVisit.getPurpose(), "test");
	}
	@Test
	public void testSetPurpose() {
		String purpose = "Consultation purpose";
		hmsVisit.setPurpose(purpose);
		Assert.assertEquals(purpose, ReflectionTestUtils.getField(hmsVisit, "purpose"));
	}
	@Test
	public void testGetBillId() {
		ReflectionTestUtils.setField(hmsVisit, "treatmentId", 1);
		Assert.assertEquals(hmsVisit.getTreatmentId(), 1);
	}
	@Test
	public void testSetBillId() {
		int billId = 1001;
		hmsVisit.setBillId(billId);
		Assert.assertEquals(billId, ReflectionTestUtils.getField(hmsVisit, "billId"));
	}
	@Test
	public void testGetHmsPatient() {
		hmsVisit.setHmsPatient(hmsPatient);
		Assert.assertEquals(hmsPatient, ReflectionTestUtils.getField(hmsVisit, "hmsPatient"));
	}
	@Test
	public void testSetHmsPatient() {
		hmsVisit.setHmsPatient(hmsPatient);
		Assert.assertEquals(hmsPatient, ReflectionTestUtils.getField(hmsVisit, "hmsPatient"));

	}

}
