package edu.imi.ir.eduimiws.mapper.attendance;


import edu.imi.ir.eduimiws.models.dto.atc.EmployeeResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EmployeeDataModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeResponseMapper {

    @Named("toEmployeeResponse")
    @Mappings({
            @Mapping(source = "businessPartnerId", target = "businessPartnerId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "fullName", target = "fullName"),
    })
    EmployeeResponse toEmployeeResponse(EmployeeDataModel employeeDataModel);

    @IterableMapping(qualifiedByName = "toEmployeeResponse")
    List<EmployeeResponse> toEmployeeResponseList(List<EmployeeDataModel> employeeDataModelList);
}
