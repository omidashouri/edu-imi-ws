package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.user.MyPrincipleUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecurityUtil {

    @MappingUtil.CreatorFromSecurityContext
    public PersonEntity creatorFromSecurityContext(PersonEntity fakeInput){
        return this.getPersonEntityFromSecurityContext();
    }

    @MappingUtil.CreatorIdFromSecurityContext
    public Long creatorIdFromSecurityContext(Long fakeInput){
        return this.getPersonEntityFromSecurityContext().getId();
    }

    protected PersonEntity getPersonEntityFromSecurityContext(){
        return  ((MyPrincipleUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPerson();
    }
}
