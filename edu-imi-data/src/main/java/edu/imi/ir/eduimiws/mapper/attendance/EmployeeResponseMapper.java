package edu.imi.ir.eduimiws.mapper.attendance;


import edu.imi.ir.eduimiws.models.dto.attendance.EmployeeDataModelDto;
import edu.imi.ir.eduimiws.models.response.attendance.response.EmployeeResponse;
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
    EmployeeResponse toEmployeeResponse(EmployeeDataModelDto employeeDataModelDto);

    @IterableMapping(qualifiedByName = "toEmployeeResponse")
    List<EmployeeResponse> toEmployeeResponseList(List<EmployeeDataModelDto> employeeDataModeDtolList);
}
