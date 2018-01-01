package com.evoke.hms.controllers;

import org.hibernate.HibernateException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.evoke.hms.exceptions.UserNameAlreadyExistsException;
import com.evoke.hms.exceptions.UserNotFoundException;
import com.evoke.hms.forms.HMSPatientForm;
import com.evoke.hms.forms.HMSPayBillForm;
import com.evoke.hms.forms.HMSVisitForm;
import com.evoke.hms.forms.ManageVisitsForm;
import com.evoke.hms.forms.RegistrationForm;


public interface IHomeController {
	ModelAndView welcome();
	ModelAndView login();
	ModelAndView homePage();
	ModelAndView UserRegistration(RegistrationForm registrationForm);
	ModelAndView registerUser(RegistrationForm registrationForm, BindingResult result) throws UserNameAlreadyExistsException, NullPointerException;
	ModelAndView updatePatientProfile(HMSPatientForm patientForm, BindingResult result) throws UserNotFoundException;
	ModelAndView accessDenied();
	ModelAndView searchProfile();
	ModelAndView deleteProfile();
	ModelAndView removeProfile(String hmsId) throws HibernateException, UserNotFoundException;
	ModelAndView editProfile(String hmsId) throws UserNotFoundException;
	ModelAndView createVisit(HMSVisitForm visitForm);
	ModelAndView addVisit(HMSVisitForm visitForm, BindingResult result) throws NullPointerException;
	ModelAndView visitManagement(ManageVisitsForm manageVists);
	ModelAndView editvisit(HMSVisitForm visitForm, int id);
	String editVisit(HMSVisitForm visitForm, BindingResult result) throws NullPointerException;
	String deleteVisit(@PathVariable int id );
	ModelAndView payBill(HMSPayBillForm payBillForm);
	ModelAndView addBill(HMSPayBillForm payBillForm, BindingResult result);
	

}
