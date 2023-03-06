package edu.imi.ir.eduimiws.mapper.mainparts;


import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {SecurityUtil.class, CommonUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL
        , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentCodeApiDtoFarapayamakSendSmsDtoMapper {

//    for more than one number handle MappingUtil.ListStringToCommaSeparatorString
    @Named("paymentCodeApiDtoToFarapayamakSendSmsDto")
    @Mappings({
            @Mapping(source = "creatorId", target = "creatorId",
                    qualifiedBy = {MappingUtil.SecurityUtil.class,
                            MappingUtil.CreatorIdFromSecurityContext.class}),//100160
            @Mapping(source = "nationalCode", target = "creatorFullName",
                    qualifiedBy = {MappingUtil.SecurityUtil.class,
                            MappingUtil.CreatorFullNameFromSecurityContext.class}),//اميد عاشوري
            @Mapping(source = "payerContact.mobilePhone", target = "to"),
            @Mapping(target = "isFlash", constant = "true")
    })
    @BeanMapping(ignoreByDefault = true)
    FarapayamakSendSmsDto paymentCodeApiDtoToFarapayamakSendSmsDto(PaymentCodeApiDto paymentCodeApiDto,
                                                                   @Context FarapayamakCredential context);


    @IterableMapping(qualifiedByName = "paymentCodeApiDtoToFarapayamakSendSmsDto")
    List<FarapayamakSendSmsDto> paymentCodeApiDtosToFarapayamakSendSmsDtos(List<PaymentCodeApiDto> paymentCodeApiDtos,
                                                                           @Context FarapayamakCredential context);

    @AfterMapping
    default void handleFarapayamakCredentials(@Context FarapayamakCredential context,
                                              @MappingTarget FarapayamakSendSmsDto target) {
        target.setUsername(context.getUsername());
        target.setPassword(context.getPassword());
        target.setFrom(context.getSendNumberOne());
    }


    default void updateToByListNumbers(List<String> numbers, @MappingTarget FarapayamakSendSmsDto target){
        target.setTo(numbers.stream().collect(Collectors.joining(",")));
    }
}
