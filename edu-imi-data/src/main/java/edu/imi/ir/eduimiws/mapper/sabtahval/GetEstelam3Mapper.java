package edu.imi.ir.eduimiws.mapper.sabtahval;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.sabtahval.GetEstelam3Dto;
import edu.imi.ir.eduimiws.models.wsdl.sabtahval.GetEstelam3;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {PersonInfoMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GetEstelam3Mapper {

    GetEstelam3Mapper INSTANCE = Mappers.getMapper(GetEstelam3Mapper.class);
    @Mappings({
        @Mapping(source = "arg0", target = "arg0"),
        @Mapping(source = "arg1", target = "arg1"),
        @Mapping(source = "arg2", target = "arg2"),
        @Mapping(source = "arg3", target = "arg3"),
        @Mapping(source = "arg4", target = "arg4")

    })
    @BeanMapping(ignoreByDefault = true)
    GetEstelam3Dto toGetEstelam3Dto(GetEstelam3 getEstelam3, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    GetEstelam3 toGetEstelam3(GetEstelam3Dto getEstelam3Dto, @Context CycleAvoidingMappingContext context);

    List<GetEstelam3> toGetEstelam3(List<GetEstelam3Dto> getEstelam3Dtos, @Context CycleAvoidingMappingContext context);

    List<GetEstelam3Dto> toGetEstelam3Dtos(List<GetEstelam3> getEstelam3s, @Context CycleAvoidingMappingContext context);

}
