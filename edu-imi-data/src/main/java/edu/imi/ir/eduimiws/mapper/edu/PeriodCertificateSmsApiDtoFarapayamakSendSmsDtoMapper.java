package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCertificateSmsApiDto;
import edu.imi.ir.eduimiws.models.helper.DefaultValues;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper {

   @Named("periodCertificateSmsApiDtoToFarapayamakSendSmsDto")
    @Mappings({
            @Mapping(source = "phone", target = "to")

    })
    @BeanMapping(ignoreByDefault = true)
    FarapayamakSendSmsDto periodCertificateSmsApiDtoToFarapayamakSendSmsDto(PeriodCertificateSmsApiDto source);

    @IterableMapping(qualifiedByName = "periodCertificateSmsApiDtoToFarapayamakSendSmsDto")
    List<FarapayamakSendSmsDto> periodCertificateSmsApiDtosToFarapayamakSendSmsDtos(List<PeriodCertificateSmsApiDto> periodCertificateSmsApiDtos);





    default void updateMessageCompany(@MappingTarget FarapayamakSendSmsDto farapayamakSendSmsDto,
                                      @Context DefaultValues defaultValues) {
        farapayamakSendSmsDto.setText(defaultValues.getCertificateDeliverySmsCompanyText());
    }

    default void updateMessagePersonal(@MappingTarget FarapayamakSendSmsDto farapayamakSendSmsDto,
                                       @Context DefaultValues defaultValues) {
        farapayamakSendSmsDto.setText(defaultValues.getCertificateDeliverySmsPersonalText());
    }
}
