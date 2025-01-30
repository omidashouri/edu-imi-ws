package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.models.projections.crm.AccountForPaymentCodeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.QueryHint;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {


    @EntityGraph(value = "AccountEntity.findAccountContactCompany", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    AccountEntity findByAccountApi_AccountPublicId(String accountPublicId);

    @EntityGraph(value = "AccountEntity.findAllJoins", type = EntityGraph.EntityGraphType.LOAD)
    AccountEntity readByAccountApi_AccountPublicId(String accountPublicId);

    @EntityGraph(value = "AccountEntity.findAllJoins", type = EntityGraph.EntityGraphType.LOAD)
    AccountEntity readById(Long id);

    @Query(name = "AccountEntity.queryPageableAccountForPaymentCodeProjection")
    Page<AccountForPaymentCodeProjection> queryPageableAccountForPaymentCodeProjection(
            @Param("id") Long id,
            @Param("accountPublicId") String accountPublicId,
            @Param("economicalCode") String economicalCode,
            @Param("accountName") String accountName,
            @Param("mainPhone") String mainPhone,
            @Param("otherPhone") String otherPhone,
            Pageable pageable);


}
