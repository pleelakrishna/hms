package com.evoke.hms.converters;

import org.springframework.stereotype.Component;

import com.evoke.hms.business.IHMSVisitBusinessModel;
import com.evoke.hms.forms.IHMSVisitForm;

@Component
public class VisitBusinessToFormConverter extends HMSAbstractConverter<IHMSVisitBusinessModel, IHMSVisitForm> {
	@Override
	public IHMSVisitForm convert(IHMSVisitBusinessModel source) {
		// TODO Auto-generated method stub
		return super.convert(source);
	}

}
