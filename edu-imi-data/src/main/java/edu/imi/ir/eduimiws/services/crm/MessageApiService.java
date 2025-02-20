package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.MessageApiEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.MessageApiDto;

@MappingUtil.MessageApiUtil
public interface MessageApiService {

    MessageApiEntity findEntityByMessageId(Long messageId);

//    MessageApiDto findDtoByMessageId(Long messageId);
//
//    @MappingUtil.MessageIdToMessagePublicId
//    String findMessageApiPublicIdByMessageId(Long messageId);
}
