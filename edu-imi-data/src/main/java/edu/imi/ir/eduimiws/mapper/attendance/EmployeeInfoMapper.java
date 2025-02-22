package edu.imi.ir.eduimiws.mapper.attendance;


import edu.imi.ir.eduimiws.models.dto.attendance.EmployeeInfoDto;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EmployeeInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeInfoMapper {

    @Named("toEmployeeInfoDto")
    @Mappings({
            @Mapping(source = "id", target = "employeeInfoId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "employmentStartDate", target = "employmentStartDate"),
            @Mapping(source = "employmentTerminationDate", target = "employmentTerminationDate")
    })
    EmployeeInfoDto toEmployeeInfoDto(EmployeeInfo employeeInfo);

    @IterableMapping(qualifiedByName = "toEmployeeInfoDto")
    List<EmployeeInfoDto> toEmployeeResponseList(List<EmployeeInfo> employeeInfos);
}
