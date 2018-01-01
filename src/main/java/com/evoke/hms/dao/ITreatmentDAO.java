package com.evoke.hms.dao;

import java.util.List;

import com.evoke.hms.model.ITreatments;
import com.evoke.hms.model.Treatments;

public interface ITreatmentDAO extends IGenericDAO<Treatments> {
	List<? extends ITreatments>getTreatments();
	ITreatments getTreatment(int id);
}
