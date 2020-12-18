package edu.imi.ir.eduimiws.predicates.v2;

import com.google.common.base.Joiner;
import com.querydsl.core.types.dsl.BooleanExpression;
import edu.imi.ir.eduimiws.exceptions.QueryDSLPredicateBuildException;
import edu.imi.ir.eduimiws.specifications.SearchOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryDSLPredicatesBuilderSe<T> {
    private final List<SearchCriteriaSe> searchCriteriaListSe;
    private final Class<T> entityClass;

    public QueryDSLPredicatesBuilderSe(Class<T> entityClass) {
        this.searchCriteriaListSe = new ArrayList<>();
        this.entityClass = entityClass;
    }

    public QueryDSLPredicatesBuilderSe with(final String orPredicate, final String key, final String operation,
                                            final Object value, final String prefix, final String suffix) {

        String newOperation = null;
        String newOrPredicate;

        if (operation != null) {
            if (operation.equalsIgnoreCase(":")) {
                boolean startWithAsterisk = operation.contains("*");
                boolean endWithAsterisk = operation.contains("*");
                if (startWithAsterisk && endWithAsterisk) {
                    newOperation = "**";
                } else if (startWithAsterisk) {
                    newOperation = "*_";
                } else if (endWithAsterisk) {
                    newOperation = "_*";
                }
            }
        }

        if (orPredicate != null && orPredicate.equalsIgnoreCase("'")) {
            newOrPredicate = "1";
        } else {
            newOrPredicate = "0";
        }
        searchCriteriaListSe.add(new SearchCriteriaSe(newOrPredicate != null ? newOrPredicate : orPredicate,
                key, newOperation != null ? newOperation : operation, value, prefix, suffix));
        return this;
    }

    public QueryDSLPredicatesBuilderSe with(final String search) {
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern
                .compile("(\\p{Punct}?)(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),",
                        Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(search+",");
        while (matcher.find()) {
            this.with(matcher.group(1), matcher.group(2), matcher.group(3),
                    matcher.group(5), matcher.group(4), matcher.group(6));
        }
        return this;
    }

    public BooleanExpression build() throws QueryDSLPredicateBuildException {
        if (searchCriteriaListSe.size() == 0) {
            return null;
        }

        final List<BooleanExpression> andPredicates = new ArrayList<>();
        QueryDSLPredicateSe<T> predicate;
//        omiddo: in 'searchCriteriaListSe' remove those which are not null and have 1 in orPredicate before enter loop
        for (final SearchCriteriaSe param : searchCriteriaListSe) {
            predicate = new QueryDSLPredicateSe<>(param);
            final BooleanExpression exp = predicate.getPredicate(entityClass);
            if (exp != null) {
                andPredicates.add(exp);
            }
        }

        final List<BooleanExpression> orPredicates = new ArrayList<>();
        for (final SearchCriteriaSe param : searchCriteriaListSe) {
            if (param.getOrPredicate() != null && param.getOrPredicate().equalsIgnoreCase("1")) {
                predicate = new QueryDSLPredicateSe<>(param);
                final BooleanExpression exp = predicate.getPredicate(entityClass);
                if (exp != null) {
                    orPredicates.add(exp);
                }
            }
        }

        BooleanExpression result = andPredicates.get(0);
        for (int i = 1; i < andPredicates.size(); i++) {
            result = result.and(andPredicates.get(i));
        }
        if (orPredicates.size() > 0) {
            for (int i = 1; i < orPredicates.size(); i++) {
                result = result.or(orPredicates.get(i));
            }
        }

        return result;
    }

    public List<SearchCriteriaSe> getSearchCriteriaListSe() {
        return searchCriteriaListSe;
    }
}
