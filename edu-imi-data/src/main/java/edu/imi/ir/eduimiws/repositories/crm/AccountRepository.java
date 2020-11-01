package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {


    @EntityGraph(value = "AccountEntity.findAccountContactCompany", type = EntityGraph.EntityGraphType.LOAD)
    AccountEntity findByAccountApi_AccountPublicId(String accountPublicId);
}
