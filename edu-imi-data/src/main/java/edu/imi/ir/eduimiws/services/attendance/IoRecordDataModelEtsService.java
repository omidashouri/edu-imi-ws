package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.models.response.attendance.response.IoRecordDataModelResponse;

import java.util.List;

public interface IoRecordDataModelEtsService {

    List<IoRecordDataModelResponse> getAllIoRecordsFromApiByDate(String jalaliDate);
    List<IoRecordDataModelResponse> getIoRecordByDateRange(String jalaliFromDate, String jalaliToDate);
}
