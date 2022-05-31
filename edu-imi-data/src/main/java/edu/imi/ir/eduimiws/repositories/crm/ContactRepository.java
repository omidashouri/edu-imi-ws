package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.models.projections.crm.ContactForPaymentCodeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Long>
//        , QuerydslPredicateExecutor<ContactEntity>, QuerydslBinderCustomizer<QContactEntity>
{
//NU
//    List<ContactEntity> findAllByPersonsIn(List<PersonEntity> personEntities);

/*      @Override
      default public void customize(
              QuerydslBindings bindings, QContactEntity root) {
            bindings.bind(String.class)
                    .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
            bindings.excluding(root.id);
      }*/


    Long countByNationCode(String nationCode);

    @EntityGraph(value = "ContactEntity.findContactContactApi", type = EntityGraph.EntityGraphType.LOAD)
    ContactEntity readById(Long id);

    @EntityGraph(value = "ContactEntity.findContactSubGraphPersonsPersonApi", type = EntityGraph.EntityGraphType.LOAD)
    List<ContactEntity> findContactEntitiesByNationCode(@Param("nationCode") String nationalCode);

    @EntityGraph(value = "ContactEntity.findContactAccount", type = EntityGraph.EntityGraphType.LOAD)
    Page<ContactEntity> findAll(Pageable pageable);


    @EntityGraph(value = "ContactEntity.findContactSubGraphPersonsPersonApi", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    ContactEntity findByContactWebService_ContactPublicId(String contactPublicId);

    @EntityGraph(value = "ContactEntity.findContactSubGraphPersonsPersonApiAndContactApi", type = EntityGraph.EntityGraphType.LOAD)
    List<ContactEntity> findByIdIn(List<Long> contactIds);

    @Query(name = "ContactEntity.queryPageablePaymentCodeApiProjection")
    Page<ContactForPaymentCodeProjection> queryPageableContactForPaymentCodeProjection(
            @Param("id") Long id,
            @Param("contactPublicId") String contactPublicId,
            @Param("nationalCode") String nationalCode,
            @Param("firstName") String firstName,
            @Param("middleName") String middleName,
            @Param("lastName") String lastName,
            @Param("mobilePhone") String mobilePhone,
            @Param("birthDate") String birthDate,
            @Param("fullName") String fullName,
            Pageable pageable);
}
