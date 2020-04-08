package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.repositories.crm.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

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
