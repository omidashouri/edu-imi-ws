/*
package edu.imi.ir.eduimiws.specifications.crm;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import edu.imi.ir.eduimiws.specifications.SearchCriteriaOld;
import net.shibboleth.utilities.java.support.annotation.Prototype;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Prototype
//@RequiredArgsConstructor
public class ContactPredicateBuilderArchive {

    private List<SearchCriteriaOld> params;

    public ContactPredicateBuilderArchive() {
        params = new ArrayList<>();
    }

    public ContactPredicateBuilderArchive with(
            String key, String operation, Object value) {

        params.add(new SearchCriteriaOld(key, operation, value));
        return this;
    }

    public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = params.stream().map(param -> {
            ContactPredicate predicate = new ContactPredicate(param);
            return predicate.getPredicate();
        }).filter(Objects::nonNull).collect(Collectors.toList());

        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression predicate : predicates) {
            result = result.and(predicate);
        }
        return result;
    }
}
*/
