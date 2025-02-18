package edu.imi.ir.eduimiws.repositories.crm.querydsl;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
//import edu.imi.ir.eduimiws.domain.crm.QContactEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*@Repository
public interface ContactQueryDslRepository extends CrudRepository<ContactEntity, Long>,
        QuerydslPredicateExecutor<ContactEntity>,
        QuerydslBinderCustomizer<QContactEntity> {
    @Override
    default public void customize(
            QuerydslBindings bindings, QContactEntity root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
        bindings.excluding(root.id);
    }
}*/
