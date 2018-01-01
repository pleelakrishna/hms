package com.evoke.hms.converters.FormToVO;

import org.springframework.stereotype.Component;

import com.evoke.hms.business.IBillPaymentDetailsBusinessModel;
import com.evoke.hms.converters.HMSAbstractConverter;
import com.evoke.hms.forms.IHMSPayBillForm;


@Component
public class BillFormToBusinessConverter extends HMSAbstractConverter<IHMSPayBillForm, IBillPaymentDetailsBusinessModel>{
	
	@Override
	public IBillPaymentDetailsBusinessModel convert(IHMSPayBillForm source) {
		
		return super.convert(source);
	}

}
