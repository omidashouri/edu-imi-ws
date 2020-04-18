package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonWebServiceFastDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {



    PersonWebServiceFastDto getUserFastDto(String userName);

    List<PersonEntity> generatePersonContactPublicIdByPersons(List<PersonEntity> newPersons);
    List<PersonEntity> generatePersonPublicIdByPersons(List<PersonEntity> newPersons);
    List<PersonEntity> generateContactPublicIdByPersons(List<PersonEntity> newPersons);
}
