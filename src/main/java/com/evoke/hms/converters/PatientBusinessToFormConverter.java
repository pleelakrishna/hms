package com.evoke.hms.converters;

import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.forms.IHMSPatientForm;

@Component
public class PatientBusinessToFormConverter extends HMSAbstractConverter<IHMSPatientBusinessModel, IHMSPatientForm> {
	@Override
	public IHMSPatientForm convert(IHMSPatientBusinessModel source) {
		return super.convert(source);
	}
	}
