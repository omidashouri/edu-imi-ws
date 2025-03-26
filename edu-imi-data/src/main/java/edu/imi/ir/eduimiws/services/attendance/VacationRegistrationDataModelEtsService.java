package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.models.response.attendance.response.VacationRegistrationDataModelResponse;

import java.util.List;

public interface VacationRegistrationDataModelEtsService {

    List<VacationRegistrationDataModelResponse> getAllVacationRegistrationFromApiByDate(String jalaliDate);
}
