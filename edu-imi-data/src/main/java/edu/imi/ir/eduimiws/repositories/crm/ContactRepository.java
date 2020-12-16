package edu.imi.ir.eduimiws.repositories.crm;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.QContactEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Long>,
        QuerydslPredicateExecutor<ContactEntity>, QuerydslBinderCustomizer<QContactEntity> {
//NU
//    List<ContactEntity> findAllByPersonsIn(List<PersonEntity> personEntities);

      @Override
      default public void customize(
              QuerydslBindings bindings, QContactEntity root) {
            bindings.bind(String.class)
                    .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
//            bindings.excluding(root.email);
      }


      Long countByNationCode(String nationCode);

      @EntityGraph(value = "ContactEntity.findContactSubGraphPersonsPersonApi", type = EntityGraph.EntityGraphType.LOAD)
      List<ContactEntity> findContactEntitiesByNationCode(@Param("nationCode") String nationalCode);

      Page<ContactEntity> findAll(Pageable pageable);


      @EntityGraph(value = "ContactEntity.findContactSubGraphPersonsPersonApi", type = EntityGraph.EntityGraphType.LOAD)
      ContactEntity findByContactWebService_ContactPublicId(String contactPublicId);

      @EntityGraph(value ="ContactEntity.findContactSubGraphPersonsPersonApiAndContactApi",type = EntityGraph.EntityGraphType.LOAD)
      List<ContactEntity> findByIdIn(List<Long> contactIds);
}
