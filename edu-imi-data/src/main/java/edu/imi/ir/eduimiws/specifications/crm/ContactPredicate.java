package edu.imi.ir.eduimiws.specifications.crm;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.specifications.SearchCriteriaOld;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isNumeric;

@Component
@RequiredArgsConstructor
public class ContactPredicate {

    private final SearchCriteriaOld criteria;
//    = new SearchCriteriaOld();

    public BooleanExpression getPredicate() {
        PathBuilder<ContactEntity> entityPath = new PathBuilder<>(ContactEntity.class, "contactEntity");

//        Here convert to number
        if (isNumeric(criteria.getValue().toString())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getValue().toString());
            switch (criteria.getOperation()) {
                case ":":
                    return path.eq(value);
                case ">=":
                    return path.goe(value);
                case "=<":
                    return path.loe(value);
                case "!":
                    return path.ne(value);
                case ">":
                    return path.gt(value);
                case "<":
                    return path.lt(value);
                default:
                    return null;
            }
        } else {
            StringPath path = entityPath.getString(criteria.getKey());
//            if (criteria.getOperation().equals(":")) {
            switch (criteria.getOperation()) {
                case ":":
                    return path.equalsIgnoreCase(criteria.getValue().toString());
                case "!":
                    return path.contains(criteria.getValue().toString()).not();
//                        return path.notLike(criteria.getValue().toString());
                case "~":
//                        return path.like(criteria.getValue().toString());
                    return path.contains(criteria.getValue().toString());
                case "*_":
                    return path.like(criteria.getValue().toString() + "%");
                case "_*":
                    return path.like("%" + criteria.getValue().toString());
                case "**":
                    return path.like("%" + criteria.getValue().toString() + "%");
                default:
                    return null;
//                return path.containsIgnoreCase(criteria.getValue().toString());
            }
//            }
//            return null;
        }
    }
}
