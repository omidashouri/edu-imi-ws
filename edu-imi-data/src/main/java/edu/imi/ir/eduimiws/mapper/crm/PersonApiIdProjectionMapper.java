package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.projections.crm.PersonApiIdProjection;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonApiIdProjectionMapper {

    PersonApiIdProjectionMapper INSTANCE = Mappers.getMapper(PersonApiIdProjectionMapper.class);

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "personId",target = "personId"),
            @Mapping(source = "contactId",target = "contactId")
    })
    PersonApiEntity toPersonWebServiceEntity(PersonApiIdProjection personApiIdProjection, @Context CycleAvoidingMappingContext context);

    List<PersonApiEntity> toPersonWebServiceEntitys(List<PersonApiIdProjection> personApiIdProjections, @Context CycleAvoidingMappingContext context);

}
