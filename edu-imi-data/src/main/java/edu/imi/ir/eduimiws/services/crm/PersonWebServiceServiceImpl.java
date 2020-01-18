package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.mapper.PersonWebServiceMapper;
import edu.imi.ir.eduimiws.repositories.crm.PersonWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonWebServiceServiceImpl implements PersonWebServiceService{

    private final PersonWebServiceMapper personWebServiceMapper;
    private final PersonWebServiceRepository personWebServiceRepository;
    private final ErpPasswordEncoder erpPasswordEncoder;
    private final Utils utils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        check user name is in database

//        check username has public id -> if not generate public ID for contact and person

//        load user




        return null;
    }


}
