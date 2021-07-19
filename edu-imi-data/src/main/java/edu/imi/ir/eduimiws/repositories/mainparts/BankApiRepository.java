package edu.imi.ir.eduimiws.repositories.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.BankApiEntity;
import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankApiRepository extends CrudRepository<BankApiEntity, Long> {

    BankApiEntity findByBankPublicId(String bankPublicId);
}
