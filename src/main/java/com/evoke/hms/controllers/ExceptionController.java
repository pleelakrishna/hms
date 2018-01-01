package com.evoke.hms.controllers;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.evoke.hms.enums.Pages;
import com.evoke.hms.exceptions.UserNameAlreadyExistsException;
import com.evoke.hms.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController implements IExceptionController {
	
	@Override
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView NullPointerException(NullPointerException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "Something went wrong!!!");
		mav.addObject("message", "Please try later");
		mav.setViewName(Pages.exception.name());
		return mav;

	}
	
	/**
	 * 
	 * @param UserNotFoundException
	 * @return exception page
	 */
	@Override
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView UserNotFoundException(UserNotFoundException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "User Not Found");
		mav.addObject("message", "Invalid HMS Id, please try  with another ID");
		mav.setViewName(Pages.exception.name());
		return mav;

	}
	
	/**
	 * 
	 * @param SQLException
	 * @return exception page
	 */
	@Override
	@ExceptionHandler(SQLException.class)
	public ModelAndView SQLException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName(Pages.exception.name());
		return mav;

	}
	
	@Override
	@ExceptionHandler(UserNameAlreadyExistsException.class)
	public ModelAndView DataIntegrityException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", "Username already exists, Please try with another username");
		mav.setViewName(Pages.exception.name());
		return mav;

	}

	/**
	 * 
	 * @param Exception
	 * @return Exception page
	 */
	@Override
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName(Pages.exception.name());
		return mav;

	}

}
