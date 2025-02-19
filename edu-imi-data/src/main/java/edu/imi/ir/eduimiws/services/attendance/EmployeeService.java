package edu.imi.ir.eduimiws.services.attendance;


import edu.imi.ir.eduimiws.models.dto.atc.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getAllEmployees();
}
