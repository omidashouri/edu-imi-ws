package edu.imi.ir.eduimiws.mapper.attendance;

import edu.imi.ir.eduimiws.models.dto.attendance.EmployeeDataModelDto;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EmployeeDataModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeDataModelMapper {
    @Named("toEmployeeDataModelDto")
    @Mappings({
            @Mapping(source = "businessPartnerId", target = "businessPartnerId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "fullName", target = "fullName"),
    })
    EmployeeDataModelDto toEmployeeDataModelDto(EmployeeDataModel employeeDataModel);

    @IterableMapping(qualifiedByName = "toEmployeeDataModelDto")
    List<EmployeeDataModelDto> toEmployeeDataModelDtoList(List<EmployeeDataModel> employeeDataModelList);
}
