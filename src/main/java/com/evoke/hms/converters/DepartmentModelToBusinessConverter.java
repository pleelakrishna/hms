package com.evoke.hms.converters;

import org.springframework.stereotype.Component;

import com.evoke.hms.business.IDoctorDeparmentsBusinessModel;
import com.evoke.hms.model.IDoctorDeparments;

@Component
public class DepartmentModelToBusinessConverter extends HMSAbstractConverter<IDoctorDeparments, IDoctorDeparmentsBusinessModel> {
	@Override
	public IDoctorDeparmentsBusinessModel convert(IDoctorDeparments source) {
		return super.convert(source);
	}
}
