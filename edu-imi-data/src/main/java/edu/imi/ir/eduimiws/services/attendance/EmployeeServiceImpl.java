package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.domain.atc.EmployeeInfoEtsApiEntity;
import edu.imi.ir.eduimiws.mapper.attendance.EmployeeDataModelMapper;
import edu.imi.ir.eduimiws.mapper.attendance.EmployeeInfoDtoMapper;
import edu.imi.ir.eduimiws.mapper.attendance.EmployeeInfoMapper;
import edu.imi.ir.eduimiws.mapper.attendance.EmployeeResponseMapper;
import edu.imi.ir.eduimiws.models.response.attendance.response.EmployeeInfoResponse;
import edu.imi.ir.eduimiws.models.response.attendance.response.EmployeeResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.*;
import edu.imi.ir.eduimiws.repositories.attendance.EmployeeEtsApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final EmployeeDataModelMapper employeeDataModelMapper;
    private final EmployeeInfoMapper employeeInfoMapper;
    private final EmployeeInfoDtoMapper employeeInfoDtoMapper;
    private final EmployeeEtsApiRepository employeeInfoRepository;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        ArrayOfEmployeeDataModel employeeDataModel = this.getEtsSoapService().getAllEmployees();
        return Stream.of(employeeDataModel)
                .filter(Objects::nonNull)
                .map(ArrayOfEmployeeDataModel::getEmployeeDataModel)
                .filter(Objects::nonNull)
                .map(employeeDataModelMapper::toEmployeeDataModelDtoList)
                .map(employeeResponseMapper::toEmployeeResponseList)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }


    @Override
    public List<EmployeeInfoResponse> getAllEmployeesInfo() {
        val allEmployeesInfo = this.getEtsSoapService().getAllEmployeesInfo();
        return Stream.of(allEmployeesInfo)
                .filter(Objects::nonNull)
                .map(ArrayOfEmployeeInfo::getEmployeeInfo)
                .map(employeeInfoMapper::toEmployeeResponseList)
                .map(employeeInfoDtoMapper::toEmployeeInfoResponseList)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public void updateAllEmployeeInfo() {
        val savedEmployeesInfo = employeeInfoRepository.findAll();
        val apiEmployeesInfo = this.getEtsSoapService().getAllEmployeesInfo().getEmployeeInfo();
        Set<String> savedPersonalCodes = StreamSupport.stream(savedEmployeesInfo.spliterator(), false)
                .map(EmployeeInfoEtsApiEntity::getEmployeeCode)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        if(!savedPersonalCodes.isEmpty()){
            val newEmployees = apiEmployeesInfo.stream().filter(employeeInfo ->
                            !savedPersonalCodes.contains(employeeInfo.getEmployeeCode()))
                    .map(employeeInfoMapper::toEmployeeInfoDto)
                    .map(employeeInfoDtoMapper::toEmployeeInfoEtsApiEntity)
                    .collect(Collectors.toList());
            employeeInfoRepository.saveAll(newEmployees);
        }else {
            val newEmployees = apiEmployeesInfo.stream()
                    .filter(employeeInfo -> Objects.nonNull(employeeInfo.getEmployeeCode()))
                    .map(employeeInfoMapper::toEmployeeInfoDto)
                    .map(employeeInfoDtoMapper::toEmployeeInfoEtsApiEntity)
                    .collect(Collectors.toList());
            employeeInfoRepository.saveAll(newEmployees);
        }
    }

    private EtsGeneralDataProviderServiceSoap getEtsSoapService() {
        return etsGeneralDataProviderService.getEtsGeneralDataProviderServiceSoap();
    }

    public int toEmployeeInfoEtsApiEntity(EmployeeInfoEtsApiEntity entity,EmployeeInfo employeeInfo) {
        return entity.getEmployeeCode().compareTo(employeeInfo.getEmployeeCode());
    }
}
