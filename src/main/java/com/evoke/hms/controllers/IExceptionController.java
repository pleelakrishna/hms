package com.evoke.hms.controllers;

import org.springframework.web.servlet.ModelAndView;

import com.evoke.hms.exceptions.UserNotFoundException;

public interface IExceptionController {
	   ModelAndView exception(Exception e);
	   public ModelAndView NullPointerException(NullPointerException e);
	   public ModelAndView UserNotFoundException(UserNotFoundException e);
	   public ModelAndView SQLException(Exception e);
	   public ModelAndView DataIntegrityException(Exception e);
}
