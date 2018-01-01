package com.evoke.hms.converters.FormToVO;

import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSPatientBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.forms.IHMSPatientForm;

@Component
public class PatientFormToBusinessConverter extends HMSAbstractConverter<IHMSPatientForm, IHMSPatientBusinessModel>{
	@Override
	public IHMSPatientBusinessModel convert(IHMSPatientForm source) {
		
		return super.convert(source);
	}
}
