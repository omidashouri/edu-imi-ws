package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.MessageApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageApiRepository extends CrudRepository<MessageApiEntity, Long> {

    MessageApiEntity findByMessageId(Long messageId);
}
