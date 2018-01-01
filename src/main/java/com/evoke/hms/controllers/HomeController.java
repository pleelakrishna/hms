package com.evoke.hms.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.evoke.hms.business.IBillPaymentDetailsBusinessModel;
import com.evoke.hms.business.IDoctorDeparmentsBusinessModel;
import com.evoke.hms.business.IHMSAppGroupRolesBusinessModel;
import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.business.IHMSVisitBusinessModel;
import com.evoke.hms.business.IRegistrationBusinessModel;
import com.evoke.hms.business.ITreatmentsBusinessModel;
import com.evoke.hms.converters.PatientBusinessToFormConverter;
import com.evoke.hms.converters.VisitBusinessToFormConverter;
import com.evoke.hms.converters.FormToVO.BillFormToBusinessConverter;
import com.evoke.hms.converters.FormToVO.PatientFormToBusinessConverter;
import com.evoke.hms.converters.FormToVO.RegistrationFormToBusinessConverter;
import com.evoke.hms.converters.FormToVO.VisitFormToBusinessConverter;
import com.evoke.hms.delegates.IRegistrationDeletegate;
import com.evoke.hms.enums.Pages;
import com.evoke.hms.exceptions.UserNameAlreadyExistsException;
import com.evoke.hms.exceptions.UserNotFoundException;
import com.evoke.hms.forms.HMSPatientForm;
import com.evoke.hms.forms.HMSPayBillForm;
import com.evoke.hms.forms.HMSVisitForm;
import com.evoke.hms.forms.IHMSPatientForm;
import com.evoke.hms.forms.ManageVisitsForm;
import com.evoke.hms.forms.RegistrationForm;
import com.evoke.hms.services.IAdminService;
import com.evoke.hms.services.IPatientService;
import com.evoke.hms.services.IUserService;

/**
 * 
 * @author rpasupuleti
 *
 */	
@Controller
public class HomeController implements IHomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	private IUserService userService;
	private IPatientService patientService;
	private IAdminService adminService;


	//DTO's
	private ObjectFactory<IRegistrationBusinessModel> registrationVOFactory;

	private ObjectFactory<IHMSVisitBusinessModel> hmsVisitFactory;
	private ObjectFactory<IHMSPatientBusinessModel> hmsPatientBusinessFactory;
	private ObjectFactory<IBillPaymentDetailsBusinessModel> billPaymentDetailsVOFactory;

	@Autowired
	public void setRegistrationVOFactory(ObjectFactory<IRegistrationBusinessModel> registrationVOFactory) {
		this.registrationVOFactory = registrationVOFactory;
	}

	private ObjectFactory<IHMSPatientForm> hmsPatientFormFactory;

	@Autowired
	public void setHmsPatientFormFactory(ObjectFactory<IHMSPatientForm> hmsPatientFormFactory) {
		this.hmsPatientFormFactory = hmsPatientFormFactory;
	}



	//Converters
	private RegistrationFormToBusinessConverter registrationFormtoBusinessConverter;
	private PatientBusinessToFormConverter patientBusinessToFormConverter;
	private PatientFormToBusinessConverter patientFormToBusinessConverter;
	private VisitFormToBusinessConverter visitFormToBusinessConverter;
	private VisitBusinessToFormConverter visitBusinessToFormConverter;
	private BillFormToBusinessConverter billFormToBusinessConverter;

	//Delegates
	private IRegistrationDeletegate registrationDelegate;


	@Autowired
	public void setRegistrationDelegate(IRegistrationDeletegate registrationDelegate) {
		this.registrationDelegate = registrationDelegate;
	}


	@Autowired
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}


	@Autowired
	public void setVisitBusinessToFormConverter(VisitBusinessToFormConverter visitBusinessToFormConverter) {
		this.visitBusinessToFormConverter = visitBusinessToFormConverter;
	}


	@Autowired
	public void setVisitFormToBusinessConverter(VisitFormToBusinessConverter visitFormToBusinessConverter) {
		this.visitFormToBusinessConverter = visitFormToBusinessConverter;
	}


	@Autowired
	public void setHmsPatientBusinessFactory(ObjectFactory<IHMSPatientBusinessModel> hmsPatientBusinessFactory) {
		this.hmsPatientBusinessFactory = hmsPatientBusinessFactory;
	}


	@Autowired
	public void setPatientFormToBusinessConverter(PatientFormToBusinessConverter patientFormToBusinessConverter) {
		this.patientFormToBusinessConverter = patientFormToBusinessConverter;
	}

	@Autowired
	public void setPatientBusinessToFormConverter(PatientBusinessToFormConverter patientBusinessToFormConverter) {
		this.patientBusinessToFormConverter = patientBusinessToFormConverter;
	}
	@Autowired
	public void setRegistrationFormtoBusinessConverter(
			RegistrationFormToBusinessConverter registrationFormtoBusinessConverter) {
		this.registrationFormtoBusinessConverter = registrationFormtoBusinessConverter;
	}


	@Autowired
	public void setHmsVisitFactory(ObjectFactory<IHMSVisitBusinessModel> hmsVisitFactory) {
		this.hmsVisitFactory = hmsVisitFactory;
	}


	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setPatientService(IPatientService patientService) {
		this.patientService = patientService;
	}

	@Autowired
	public void setBillFormToBusinessConverter(BillFormToBusinessConverter billFormToBusinessConverter) {
		this.billFormToBusinessConverter = billFormToBusinessConverter;
	}

	@Autowired
	public void setBillPaymentDetailsVOFactory(ObjectFactory<IBillPaymentDetailsBusinessModel> billPaymentDetailsVOFactory) {
		this.billPaymentDetailsVOFactory = billPaymentDetailsVOFactory;
	}


	/**
	 * returns index page
	 * @param modelAndView
	 * @return
	 */
	@Override
	@RequestMapping(value="/hms", method = RequestMethod.GET)
	public ModelAndView welcome() {
		LOGGER.debug("Returning index::{}", Pages.valueOf("index"));
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Pages.index.name());
		return modelView;
	}

	/**
	 * Returns login page
	 * @param modelAndView
	 * @return
	 */
	@Override
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Pages.login.name());
		return modelView;
	}

	/**
	 * 
	 * @param modelAndView
	 * @return
	 */
	@Override
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Pages.homepage.name());
		return modelView;

	}

	/**
	 * Accessdenied page for restricting access 
	 */
	@Override
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Pages.accessdenied.name());
		return modelView;
	}

	/**
	 * Returns User Registration page
	 */
	@Override
	@RequestMapping(value = "/registration", method=RequestMethod.GET)
	public ModelAndView UserRegistration(@ModelAttribute("RegistrationForm") @Valid RegistrationForm registrationForm) {
		//Get ROLES from lookup table
		ModelAndView model = new ModelAndView();
		//Setting roles
		List<IHMSAppGroupRolesBusinessModel> roles = userService.getRoles();
		//Setting deparments
		List<IDoctorDeparmentsBusinessModel> departments = adminService.getDepartments();
		model.addObject("roles",roles);
		model.addObject("departments",departments);
		model.setViewName(Pages.registration.name());
		return model;
	}

	/**
	 * Registers a user
	 */
	@Override
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("RegistrationForm") @Valid RegistrationForm registrationForm, BindingResult result) throws UserNameAlreadyExistsException, NullPointerException {
		ModelAndView model = new ModelAndView();
		try{
			Validate.notNull(registrationForm);
			if(result.hasErrors()){
				LOGGER.error("Total errors: {}", result.getErrorCount());
				model.setViewName(Pages.registration.name());
				return model;
			}

			//Create new user::::using delegates
			IRegistrationBusinessModel registration = registrationVOFactory.getObject();
			registrationFormtoBusinessConverter.setFactoryObject(registration);
			registration = registrationFormtoBusinessConverter.convert(registrationForm);
			registrationDelegate.createNewUser(registration);
			model.setViewName(Pages.homepage.name());
			return model;
		}catch (DataIntegrityViolationException e) {
			LOGGER.error("Errors while creating new user: {}", e.getMessage());
			throw new UserNameAlreadyExistsException("User already exists");
		}
	}

	/**
	 * Search User Profile
	 */
	//Edit Profile
	@Override
	@RequestMapping(value="/searchprofile", method = RequestMethod.GET)
	public ModelAndView searchProfile() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Pages.searchprofile.name());
		return modelView;
	}

	/**
	 * Shows Delete Profile page
	 */

	//Delete Profile
	@Override
	@RequestMapping(value="/deleteprofile", method = RequestMethod.GET)
	public ModelAndView deleteProfile() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Pages.deleteprofile.name());
		return modelView;
	}

	/**
	 * Deletes Patient Profile
	 */

	@Override
	@RequestMapping(value="/deleteprofile", method = RequestMethod.POST)
	public ModelAndView removeProfile(@RequestParam String hmsId) throws UserNotFoundException  {
		ModelAndView modelView = new ModelAndView();
		Validate.notNull(hmsId);
		patientService.deleteProfile(hmsId);
		modelView.addObject("message", "User deleted successfully");
		modelView.setViewName(Pages.homepage.name());
		return modelView;
	}

	/**
	 * Shows Edit profile page
	 */
	@Override
	@RequestMapping(value="/editprofile", method = RequestMethod.GET)
	public ModelAndView editProfile(@RequestParam String hmsId) throws UserNotFoundException {
		ModelAndView modelView = new ModelAndView();
		try{
			IHMSPatientBusinessModel hmsPatient = patientService.findByHMSId(hmsId);
			IHMSPatientForm patientForm = hmsPatientFormFactory.getObject();
			//BusinessToFormConverter
			patientBusinessToFormConverter.setFactoryObject(patientForm);
			patientForm = patientBusinessToFormConverter.convert(hmsPatient);
			modelView.addObject("HMSPatientForm",patientForm);
			modelView.setViewName(Pages.editprofile.name());
		}catch (UserNotFoundException e) {
			LOGGER.error("User not found for HMSID {}",hmsId);
			throw new UserNotFoundException("User not found for HMSID {}"+hmsId);
		}
		return modelView;
	}

	/**
	 * Updates Patient Profile
	 */

	@Override
	@RequestMapping(value="/updateprofile", method = RequestMethod.POST)
	public ModelAndView updatePatientProfile(@ModelAttribute("HMSPatientForm") @Valid HMSPatientForm patientForm, BindingResult result) throws UserNotFoundException {
		LOGGER.debug("Invoked updateProfile for hms ID: {}", patientForm.getHmsUniqueId());
		ModelAndView model = new ModelAndView();
		IHMSPatientBusinessModel hmsPatient = hmsPatientBusinessFactory.getObject();
		patientFormToBusinessConverter.setFactoryObject(hmsPatient);
		hmsPatient = patientFormToBusinessConverter.convert(patientForm);
		Validate.notNull(hmsPatient);
		if(result.hasErrors()){
			LOGGER.error("Total errors: {}", result.getErrorCount());
			model.setViewName(Pages.editprofile.name());
			return model;
		}
		patientService.updateUserDetails(hmsPatient); 
		model.addObject("message", "User Details updated successfully");
		model.setViewName(Pages.homepage.name());
		return model;
	}


	@Override
	@RequestMapping(value="/createvisit", method = RequestMethod.GET)
	public ModelAndView createVisit(HMSVisitForm visitForm) {
		ModelAndView modelView = new ModelAndView();
		List<ITreatmentsBusinessModel> treatments = adminService.getTreatments();
		modelView.addObject("treatments", treatments);
		modelView.setViewName(Pages.createvisit.name());
		return modelView;
	}

	@Override
	@RequestMapping(value="/createvisit", method = RequestMethod.POST)
	public ModelAndView addVisit(HMSVisitForm visitForm, BindingResult result) throws NullPointerException {
		ModelAndView model = new ModelAndView();
		try{
			Validate.notNull(visitForm);
			if(result.hasErrors()){
				LOGGER.error("Total errors: {}", result.getErrorCount());
				model.setViewName(Pages.createvisit.name());
				return model;
			}
			//Form to Business Converter
			IHMSVisitBusinessModel hmsVisit = hmsVisitFactory.getObject();
			visitFormToBusinessConverter.setFactoryObject(hmsVisit);
			hmsVisit = visitFormToBusinessConverter.convert(visitForm);
			patientService.createVisit(hmsVisit);
			model.addObject("message", "Visit created successfully");
			model.setViewName(Pages.homepage.name());
			return model;
		}catch (DataIntegrityViolationException e) {
			LOGGER.error("Errors while creating new user: {}", e.getMessage());
		}
		return model;
	}

	@Override
	@RequestMapping(value="/managevisits", method = RequestMethod.GET)
	public ModelAndView visitManagement(@ModelAttribute("ManageVisitsForm") @Valid ManageVisitsForm manageVists) {
		ModelAndView modelView = new ModelAndView();
		List<IHMSVisitBusinessModel> hmsVisits = patientService.getVisits();
		Validate.notNull(hmsVisits);
		manageVists.setHmsVisits(hmsVisits);
		modelView.setViewName(Pages.managevisits.name());
		return modelView;
	}

	@Override
	@RequestMapping(value="/editvisit/{id}", method = RequestMethod.GET)
	public ModelAndView editvisit(@ModelAttribute("HMSVisitForm") @Valid HMSVisitForm visitForm, @PathVariable int id ) {
		Validate.notNull(id);
		IHMSVisitBusinessModel hmsVisit = patientService.getVisit(id);
		//BusinessObject to Form 
		visitBusinessToFormConverter.setFactoryObject(visitForm);
		visitForm = (HMSVisitForm) visitBusinessToFormConverter.convert(hmsVisit);  //??Data will send directly
		ModelAndView modelView = new ModelAndView();
		modelView.addObject(visitForm);
		modelView.setViewName(Pages.editvisit.name());
		return modelView;
	}


	@Override
	@RequestMapping(value="/editvisit", method = RequestMethod.POST)
	public String editVisit(HMSVisitForm visitForm, BindingResult result) throws NullPointerException {
		ModelAndView model = new ModelAndView();
		try{
			Validate.notNull(visitForm);
			if(result.hasErrors()){
				LOGGER.error("Total errors: {}", result.getErrorCount());
				model.setViewName(Pages.editvisit.name());
				//return model;
			}
			IHMSVisitBusinessModel hmsVisit = hmsVisitFactory.getObject();
			visitFormToBusinessConverter.setFactoryObject(hmsVisit);
			hmsVisit = visitFormToBusinessConverter.convert(visitForm);
			patientService.editVisit(hmsVisit);
			return "redirect:/managevisits";
			//return model;
		}catch (DataIntegrityViolationException e) {
			LOGGER.error("Errors while creating new user: {}", e.getMessage());
		}
		//return model;
		return null;
	}

	@RequestMapping(value="/deletevisit/{id}", method = RequestMethod.GET)
	public String deleteVisit(@PathVariable int id ) {
		Validate.notNull(id);
		patientService.deleteVisit(id);
		return "redirect:/managevisits";
	}


	@Override
	@RequestMapping(value="/paybill", method = RequestMethod.GET)
	public ModelAndView payBill(HMSPayBillForm payBillForm) {
		ModelAndView modelView = new ModelAndView();
		List<ITreatmentsBusinessModel> treatments = adminService.getTreatments();
		modelView.addObject("treatments", treatments);
		modelView.setViewName(Pages.paybill.name());
		return modelView;
	}

	@Override
	@RequestMapping(value="/paybill", method = RequestMethod.POST)
	public ModelAndView addBill(HMSPayBillForm payBillForm, BindingResult result){
		ModelAndView model = new ModelAndView();
		try{
			Validate.notNull(payBillForm);
			if(result.hasErrors()){
				LOGGER.error("Total errors: {}", result.getErrorCount());
				model.setViewName(Pages.paybill.name());
				return model;
			}
			//Form to Business Converter
			IBillPaymentDetailsBusinessModel billDetails = billPaymentDetailsVOFactory.getObject();
			billFormToBusinessConverter.setFactoryObject(billDetails);
			billDetails = billFormToBusinessConverter.convert(payBillForm);
			adminService.payBill(billDetails);
			model.addObject("message", "Bills created successfully");
			model.setViewName(Pages.homepage.name());
			return model;
		}catch (DataIntegrityViolationException e) {
			LOGGER.error("Errors while creating new user: {}", e.getMessage());
		}
		return model;
	}

}