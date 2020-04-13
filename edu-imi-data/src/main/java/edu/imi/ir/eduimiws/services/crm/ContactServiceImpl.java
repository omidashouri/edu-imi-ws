package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.repositories.crm.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public List<ContactDto> findContactByNationalCode(String nationalCode) {
        List<ContactEntity> contactEntities = contactRepository.findContactEntitiesByNationCode(nationalCode);
        List<ContactDto> contactDtos = contactMapper.toContactDtos(contactEntities,new CycleAvoidingMappingContext());
        return contactDtos;
    }

    @Override
    public Long getContactNumberByNationalCode(String nationalCode) {

        Long contactCount = contactRepository.countByNationCode(nationalCode);
        return contactCount;
    }

//NU
/*    @Override
    public ContactEntity findContactEntityById(Long id) {
        return contactRepository.findById(id).orElseThrow(()-> new UserServiceException("contact not found"));
    }
//NU
    @Override
    public List<ContactEntity> findAllByPersons(List<PersonEntity> personEntities) {
        return contactRepository.findAllByPersonsIn(personEntities);
    }*/
}
