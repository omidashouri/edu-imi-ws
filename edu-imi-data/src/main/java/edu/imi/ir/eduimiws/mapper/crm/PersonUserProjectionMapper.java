package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.projections.crm.PersonUserProjection;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonUserProjectionMapper {

    PersonUserProjectionMapper INSTANCE = Mappers.getMapper(PersonUserProjectionMapper.class);

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "contactId",target = "contactId"),
            @Mapping(source = "companyId",target = "companyId"),
            @Mapping(source = "username",target = "username"),
            @Mapping(source = "password",target = "password")
    })
    PersonEntity toPersonEntity(PersonUserProjection personUserProjection, @Context CycleAvoidingMappingContext context);

    List<PersonEntity> toPersonEntitys(List<PersonUserProjection> personUserProjections, @Context CycleAvoidingMappingContext context);

}
