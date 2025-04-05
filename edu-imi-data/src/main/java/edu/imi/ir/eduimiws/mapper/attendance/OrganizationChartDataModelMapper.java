package edu.imi.ir.eduimiws.mapper.attendance;

import edu.imi.ir.eduimiws.models.dto.attendance.OrganizationChartDataModelDto;
import edu.imi.ir.eduimiws.models.response.attendance.response.OrganizationChartDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.OrganizationChartDataModel;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {Timestamp.class, Date.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrganizationChartDataModelMapper {

    @Named("fromOrganizationChartDataModel")
    @Mappings({
            @Mapping(source = "organizationChartId", target = "organizationChartId"),
            @Mapping(source = "organizationChartName", target = "organizationChartName"),
            @Mapping(source = "employees", target = "employeeDataModelDto"),
    })
    OrganizationChartDataModelDto fromOrganizationChartDataModel(OrganizationChartDataModel source);

    @IterableMapping(qualifiedByName = "fromOrganizationChartDataModel")
    List<OrganizationChartDataModelDto> fromOrganizationChartDataModels(List<OrganizationChartDataModel> organizationChartDataModels);

    @Named("toOrganizationChartDataModelResponse")
    @Mappings({
            @Mapping(source = "organizationChartId", target = "organizationChartId"),
            @Mapping(source = "organizationChartName", target = "organizationChartName"),
            @Mapping(source = "employeeDataModelDto", target = "employeeDataModelDto"),
    })
    OrganizationChartDataModelResponse toOrganizationChartDataModelResponse(OrganizationChartDataModelDto source);

    @IterableMapping(qualifiedByName = "toOrganizationChartDataModelResponse")
    List<OrganizationChartDataModelResponse> fromOrganizationChartDataModelResponses(List<OrganizationChartDataModelDto> organizationChartDataModelDtos);
}
