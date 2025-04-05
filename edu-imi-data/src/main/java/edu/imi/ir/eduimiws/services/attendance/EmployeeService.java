package edu.imi.ir.eduimiws.services.attendance;


import edu.imi.ir.eduimiws.models.response.attendance.response.EmployeeInfoResponse;
import edu.imi.ir.eduimiws.models.response.attendance.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getAllEmployees();
    List<EmployeeInfoResponse> getAllEmployeesInfo();
    void updateAllEmployeeInfo();
    List<EmployeeResponse> getAllCurrentlyEmployees();

}
