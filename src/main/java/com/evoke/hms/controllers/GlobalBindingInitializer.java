package com.evoke.hms.controllers;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalBindingInitializer {
	@InitBinder
	public void registerCustomEditors(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, NumberFormat.getNumberInstance(Locale.US), true));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

}
