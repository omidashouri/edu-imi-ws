package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.InternalResponseLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface InternalResponseLogRepository extends JpaRepository<InternalResponseLogEntity, Long> {

    Optional<InternalResponseLogEntity> findByInternalRequestLog_Id(Long internalRequestLogId);

    List<InternalResponseLogEntity> findByInternalRequestLog_IdIn(Collection<Long> internalRequestLogIds);
}
