package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.InternalRequestLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InternalRequestLogRepository extends JpaRepository<InternalRequestLogEntity, Long>,
        JpaSpecificationExecutor<InternalRequestLogEntity> {

    @Query("""
            SELECT irl
            FROM InternalRequestLogEntity irl
            LEFT JOIN FETCH irl.businessOperation
            WHERE irl.requestId = :requestId
            """)
    Optional<InternalRequestLogEntity> findByRequestId(@Param("requestId") String requestId);
}
