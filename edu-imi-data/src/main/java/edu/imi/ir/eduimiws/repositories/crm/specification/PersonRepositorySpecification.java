package edu.imi.ir.eduimiws.repositories.crm.specification;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepositorySpecification extends JpaRepository<PersonEntity, Long>,
        JpaSpecificationExecutor<PersonEntity> {


    Page<PersonEntity> findAll(Specification<PersonEntity> specification, Pageable pageable);
}
