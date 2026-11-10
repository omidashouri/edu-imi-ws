package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.BusinessOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessOperationRepository extends JpaRepository<BusinessOperationEntity, Long> {

    Optional<BusinessOperationEntity> findByOperationNameAndIsActive(String operationName, Long isActive);
}
