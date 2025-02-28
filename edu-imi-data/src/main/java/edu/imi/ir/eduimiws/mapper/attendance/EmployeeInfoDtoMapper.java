package edu.imi.ir.eduimiws.mapper.attendance;


import edu.imi.ir.eduimiws.domain.attendance.EmployeeInfoEtsApiEntity;
import edu.imi.ir.eduimiws.models.dto.attendance.EmployeeInfoDto;
import edu.imi.ir.eduimiws.models.response.attendance.response.EmployeeInfoResponse;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {Timestamp.class, Date.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeInfoDtoMapper {

    @Named("toEmployeeInfoEtsApiEntity")
    @Mappings({
            @Mapping(source = "employeeInfoId", target = "employeeInfoId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "employmentStartDate", target = "employmentStartDate"),
            @Mapping(source = "employmentTerminationDate", target = "employmentTerminationDate"),
            @Mapping(target = "createDate", expression = "java(new Timestamp(new Date().getTime()))")
    })
    EmployeeInfoEtsApiEntity toEmployeeInfoEtsApiEntity(EmployeeInfoDto employeeInfoDto);

    @IterableMapping(qualifiedByName = "toEmployeeInfoEtsApiEntity")
    List<EmployeeInfoEtsApiEntity> toEmployeeInfoEtsApiEntityList(List<EmployeeInfoDto> employeeInfoDtos);

    @Named("toEmployeeInfoResponse")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "employeeInfoId", target = "employeeInfoId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "employmentStartDate", target = "employmentStartDate"),
            @Mapping(source = "employmentTerminationDate", target = "employmentTerminationDate")
    })
    EmployeeInfoResponse toEmployeeInfoResponse(EmployeeInfoDto employeeInfoDto);

    @IterableMapping(qualifiedByName = "toEmployeeInfoResponse")
    List<EmployeeInfoResponse> toEmployeeInfoResponseList(List<EmployeeInfoDto> employeeInfoDtos);

}
