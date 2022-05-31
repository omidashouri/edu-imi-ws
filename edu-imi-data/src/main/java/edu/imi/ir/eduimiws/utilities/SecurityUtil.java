package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.user.MyPrincipleUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@MappingUtil.SecurityUtil
@Component
@Slf4j
public class SecurityUtil {

    @MappingUtil.CreatorFromSecurityContext
    public PersonEntity creatorFromSecurityContext(PersonEntity fakeInput) {
        return this.getPersonEntityFromSecurityContext();
    }

    @MappingUtil.CreatorFromSecurityContextFakeDto
    public PersonEntity creatorFromSecurityContext(PersonDto fakeDtoInput) {
        return this.getPersonEntityFromSecurityContext();
    }

    @MappingUtil.CreatorIdFromSecurityContext
    public Long creatorIdFromSecurityContext(Long fakeLong) {
        return this.getPersonEntityFromSecurityContext().getId();
    }

    @MappingUtil.CreatorFullNameFromSecurityContext
    public String creatorFullNameFromSecurityContext(String fakeString) {
        return this.getPersonEntityFromSecurityContext().getFirstName()
                + " "
                + this.getPersonEntityFromSecurityContext().getLastName();
    }

    public PersonEntity getPersonEntityFromSecurityContext() {
        return ((MyPrincipleUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPerson();
    }

    @MappingUtil.PersonIdFromSecurityContext
    public Long getPersonIdFromSecurityContext() {
        return this.getPersonEntityFromSecurityContext().getId();
    }
}
