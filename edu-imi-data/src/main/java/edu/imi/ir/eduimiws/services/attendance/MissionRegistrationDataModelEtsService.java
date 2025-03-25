package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.models.response.attendance.response.MissionRegistrationDataModelResponse;

import java.util.List;

public interface MissionRegistrationDataModelEtsService {

    List<MissionRegistrationDataModelResponse> getAllMissonRegistrationFromApiByDate(String jalaliDate);
}
