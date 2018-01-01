package com.evoke.hms.converters;

import org.springframework.stereotype.Component;

import com.evoke.hms.business.ITreatmentsBusinessModel;
import com.evoke.hms.model.ITreatments;

@Component
public class TreatmentModelToVOConverter extends HMSAbstractConverter<ITreatments, ITreatmentsBusinessModel> {
	@Override
	public ITreatmentsBusinessModel convert(ITreatments source) {
		return super.convert(source);
	}
}
