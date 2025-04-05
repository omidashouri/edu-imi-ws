package edu.imi.ir.eduimiws.services.attendance;

import java.time.LocalDateTime;
import java.util.List;

public interface FunctionalityListService {

    List<String> getFunctionalityList(String employeeCode, LocalDateTime fromDate, LocalDateTime toDate);
}
