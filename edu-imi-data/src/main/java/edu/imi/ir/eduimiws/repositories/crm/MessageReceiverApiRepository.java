package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.MessageReceiverApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageReceiverApiRepository extends CrudRepository<MessageReceiverApiEntity, Long> {

}
