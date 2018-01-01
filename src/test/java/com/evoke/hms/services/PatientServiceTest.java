package com.evoke.hms.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.ObjectFactory;

import com.evoke.hms.business.IHMSVisitBusinessModel;
import com.evoke.hms.converters.VisitModelToBusinessConverter;
import com.evoke.hms.converters.VOtoModel.VisitBusinessToModelConverter;
import com.evoke.hms.dao.IVisitDAO;
import com.evoke.hms.model.HMSVisit;
import com.evoke.hms.model.IHMSVisit;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {

	IPatientService patientSerivce;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Mock
	IVisitDAO visitDAO;

	@Mock
	ObjectFactory<IHMSVisit> visitModelFactory;

	@Mock
	ObjectFactory<IHMSVisitBusinessModel> visitVOFactory; 

	@Mock
	VisitBusinessToModelConverter visitBussinessToModelConverter;

	@Mock 
	VisitModelToBusinessConverter visitModelToBusinessConverter;

	@Before
	public void setUp(){
		patientSerivce = new PatientServiceImpl();
		patientSerivce.setVisitDAO(visitDAO);
		patientSerivce.setVisitModelFactory(visitModelFactory);
		patientSerivce.setVisitBussinessToModelConverter(visitBussinessToModelConverter);
		patientSerivce.setVisitModelToBusinessConverter(visitModelToBusinessConverter);
		patientSerivce.setVisitBusinessFactory(visitVOFactory);
	}

	@Test
	public void testCreateVisit(){
		IHMSVisitBusinessModel visitVO = visitVOFactory.getObject();
		IHMSVisit visit = visitModelFactory.getObject();
		Mockito.when(visitBussinessToModelConverter.convert(visitVO)).thenReturn(visit);
		IHMSVisit result = visitBussinessToModelConverter.convert(visitVO);
		Assert.assertEquals(result, visit);
		Mockito.verify(visitBussinessToModelConverter).convert(visitVO);
		patientSerivce.createVisit(visitVO);
		Mockito.verify(visitDAO).createVisit(visit);

	}

	@Test
	public void testGetVisits(){
		List<IHMSVisitBusinessModel> visitList = new ArrayList<IHMSVisitBusinessModel>();
		List<? extends IHMSVisit> modelVisits = new ArrayList<HMSVisit>();
		IHMSVisit visit = visitModelFactory.getObject();
		Mockito.doReturn(modelVisits).when(visitDAO).getVisits();
		IHMSVisitBusinessModel visitVO = visitVOFactory.getObject();
		Mockito.when(visitModelToBusinessConverter.convert(visit)).thenReturn(visitVO);
		visitList.add(visitVO);
		Mockito.when(patientSerivce.getVisits()).thenReturn(visitList);
		List<IHMSVisitBusinessModel> result = patientSerivce.getVisits();
		Assert.assertEquals(result, visitList);		
	}

	@Test
	public void testGetVisit(){
		IHMSVisit visit = visitModelFactory.getObject();
		IHMSVisitBusinessModel visitVO = visitVOFactory.getObject();
		Mockito.when(visitDAO.getVisit(1)).thenReturn(visit);
		Mockito.when(visitModelToBusinessConverter.convert(visit)).thenReturn(visitVO);
		Mockito.when(patientSerivce.getVisit(1)).thenReturn(visitVO);
		IHMSVisitBusinessModel result = patientSerivce.getVisit(1);
		Assert.assertEquals(result, visitVO);
	}

	@Test
	public void testEditVisit(){
		IHMSVisit visit = visitModelFactory.getObject();
		IHMSVisitBusinessModel visitVO = visitVOFactory.getObject();
		Mockito.when(visitBussinessToModelConverter.convert(visitVO)).thenReturn(visit);
		patientSerivce.editVisit(visitVO);
		Mockito.verify(visitDAO).updateVisit((visit));
	}

	@Test
	public void testDeleteVisit(){
		IHMSVisit visit = visitModelFactory.getObject();
		Mockito.when(visitDAO.getVisit(1)).thenReturn(visit);
		patientSerivce.deleteVisit(1);
		Mockito.verify(visitDAO).deleteVisit(visit);

	}

}
