package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.mapper.attendance.EmployeeDataModelMapper;
import edu.imi.ir.eduimiws.mapper.attendance.EmployeeResponseMapper;
import edu.imi.ir.eduimiws.models.response.attendance.response.EmployeeResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.ArrayOfEmployeeDataModel;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderService;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderServiceSoap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final EmployeeDataModelMapper employeeDataModelMapper;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        EtsGeneralDataProviderServiceSoap soap = etsGeneralDataProviderService
                .getEtsGeneralDataProviderServiceSoap();
        ArrayOfEmployeeDataModel employeeDataModel = soap.getAllEmployees();
        return Stream.of(employeeDataModel)
                .filter(Objects::nonNull)
                .map(ArrayOfEmployeeDataModel::getEmployeeDataModel)
                .filter(Objects::nonNull)
                .map(employeeDataModelMapper::toEmployeeDataModelDtoList)
                .map(employeeResponseMapper::toEmployeeResponseList)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
