package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.models.dto.PersonWebServiceDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    PersonWebServiceDto getUserDto(String userName);
}
