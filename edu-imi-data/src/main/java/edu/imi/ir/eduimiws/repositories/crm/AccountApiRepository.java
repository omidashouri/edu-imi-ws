package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountApiRepository extends CrudRepository<AccountApiEntity,Long> {

    Optional<AccountApiEntity> findByAccountPublicId(String accountPublicId);
}
