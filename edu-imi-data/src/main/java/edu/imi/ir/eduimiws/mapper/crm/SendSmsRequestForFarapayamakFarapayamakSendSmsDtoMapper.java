package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.request.crm.SendSmsRequestForFarapayamak;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SendSmsRequestForFarapayamakFarapayamakSendSmsDtoMapper {


    @Named("toFarapayamakSendSmsDto")
    @Mappings({
            @Mapping(source = "mobileNumbers", target = "to",
                    qualifiedBy = {MappingUtil.CommonUtils.class, MappingUtil.ListStringToCommaSeparatorString.class}),
            @Mapping(source = "messageText", target = "text"),
            @Mapping(source = "isMessageFlash", target = "isFlash")

    })
    @BeanMapping(ignoreByDefault = true)
    FarapayamakSendSmsDto toFarapayamakSendSmsDto(SendSmsRequestForFarapayamak source,
                                                  @Context FarapayamakCredential context);


    @IterableMapping(qualifiedByName = "toFarapayamakSendSmsDto")
    List<FarapayamakSendSmsDto> toFarapayamakSendSmsDtos(List<SendSmsRequestForFarapayamak> sources,
                                                         @Context FarapayamakCredential context);

    @AfterMapping
/*    @Mappings({
            @Mapping(target = "username",defaultExpression = "java(context.getUsername())"),
            @Mapping(target = "password",defaultExpression = "java(context.getPassword())"),
            @Mapping(target = "from",defaultExpression = "java(context.getSendNumberOne())"),
    })*/
    default void handleFarapayamakCredentials(@Context FarapayamakCredential context,
                                              @MappingTarget FarapayamakSendSmsDto target) {
        target.setUsername(context.getUsername());
        target.setPassword(context.getPassword());
        target.setFrom(context.getSendNumberOne());

    }

}
