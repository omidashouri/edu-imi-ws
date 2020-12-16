package edu.imi.ir.eduimiws.specifications.crm;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.specifications.SearchCriteria;
import lombok.RequiredArgsConstructor;

import static org.apache.commons.lang3.StringUtils.isNumeric;

@RequiredArgsConstructor
public class ContactPredicateTest {

    private final SearchCriteria criteria;

    public BooleanExpression getPredicate() {
        PathBuilder<ContactEntity> entityPath = new PathBuilder<>(ContactEntity.class, "contactEntity");

//        Here convert to number
        if (isNumeric(criteria.getValue().toString())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getValue().toString());
            switch (criteria.getOperation()) {
                case EQUALITY:
                    return path.eq(value);
                case NEGATION:
                    return path.ne(value);
                case GREATER_THAN:
                    return path.goe(value);
                case LESS_THAN:
                    return path.loe(value);
                default:
                    return null;
            }
        } else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equals(":")) {
                switch (criteria.getOperation()) {
                    case NEGATION:
                        return path.contains(criteria.getValue().toString()).not();
//                        return path.notLike(criteria.getValue().toString());
                    case LIKE:
//                        return path.like(criteria.getValue().toString());
                        return path.contains(criteria.getValue().toString());
                    case STARTS_WITH:
                        return path.like(criteria.getValue().toString() + "%");
                    case ENDS_WITH:
                        return path.like("%" + criteria.getValue().toString());
                    case CONTAINS:
                        return path.like("%" + criteria.getValue().toString() + "%");
                    default:
                        return null;
//                return path.containsIgnoreCase(criteria.getValue().toString());
                }
            }
            return null;
        }
    }
}
