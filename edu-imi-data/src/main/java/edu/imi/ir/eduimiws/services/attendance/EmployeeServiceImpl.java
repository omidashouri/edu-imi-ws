package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.mapper.attendance.EmployeeResponseMapper;
import edu.imi.ir.eduimiws.models.dto.atc.EmployeeResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.ArrayOfEmployeeDataModel;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderService;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderServiceSoap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final EmployeeResponseMapper employeeResponseMapper;
    
    @Override
    public List<EmployeeResponse> getAllEmployees() {
        EtsGeneralDataProviderServiceSoap soap = etsGeneralDataProviderService
                .getEtsGeneralDataProviderServiceSoap();
        ArrayOfEmployeeDataModel employees = soap.getAllEmployees();
        return employeeResponseMapper.toEmployeeResponseList(employees.getEmployeeDataModel());
    }
}
