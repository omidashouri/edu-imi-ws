package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.repositories.crm.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactFastDtoMapper contactFastDtoMapper;

    @Override
    public List<ContactFastDto> findContactByNationalCode(String nationalCode) {
        List<ContactEntity> contactEntities = contactRepository.findContactEntitiesByNationCode(nationalCode);
        List<ContactFastDto> contactFastDtos = contactFastDtoMapper.toContactFastDtos(contactEntities,new CycleAvoidingMappingContext());
        return contactFastDtos;
    }

    @Override
    public Long getContactNumberByNationalCode(String nationalCode) {

        Long contactCount = contactRepository.countByNationCode(nationalCode);
        return contactCount;
    }

    @Override
    public Page<ContactEntity> findAllContactEntityPages(Pageable pageable) {
        Page<ContactEntity> contactPages = contactRepository
                .findAllContactEntityPages(pageable);
        return contactPages;
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
