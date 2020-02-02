package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.models.dto.PersonWebServiceFastDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {



    PersonWebServiceFastDto getUserFastDto(String userName);
}
