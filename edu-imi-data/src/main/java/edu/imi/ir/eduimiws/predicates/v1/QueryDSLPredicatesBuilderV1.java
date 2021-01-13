package edu.imi.ir.eduimiws.predicates.v1;

import com.google.common.base.Joiner;
import com.querydsl.core.types.dsl.BooleanExpression;
import edu.imi.ir.eduimiws.exceptions.QueryDSLPredicateBuildException;
import edu.imi.ir.eduimiws.specifications.SearchOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryDSLPredicatesBuilderV1<T> {
    private final List<SearchCriteriaV1> searchCriteriaV1List;
    private final Class<T> entityClass;

    public QueryDSLPredicatesBuilderV1(Class<T> entityClass) {
        this.searchCriteriaV1List = new ArrayList<>();
        this.entityClass = entityClass;
    }

    public QueryDSLPredicatesBuilderV1 with(final String key, final String operation, final Object value) {
        searchCriteriaV1List.add(new SearchCriteriaV1(key, operation, value));
        return this;
    }

    public QueryDSLPredicatesBuilderV1 with(final String search) {
        Pattern pattern = Pattern.compile("([^,]+)([:;!<>])([^,]+)");
        Matcher matcher = pattern.matcher(search);
        while (matcher.find()) {
            this.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        return this;
    }

    public QueryDSLPredicatesBuilderV1 withSearchString(final String search) {
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern
                .compile("(\\p{Punct}?)(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),",
                        Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(search);
        while (matcher.find()) {
            this.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        return this;
    }

    public BooleanExpression build() throws QueryDSLPredicateBuildException {
        if (searchCriteriaV1List.size() == 0) {
            return null;
        }

        final List<BooleanExpression> predicates = new ArrayList<>();
        QueryDSLPredicateV1<T> predicate;
        for (final SearchCriteriaV1 param : searchCriteriaV1List) {
            predicate = new QueryDSLPredicateV1<>(param);
            final BooleanExpression exp = predicate.getPredicate(entityClass);
            if (exp != null) {
                predicates.add(exp);
            }
        }

        BooleanExpression result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }
        return result;
    }

    public List<SearchCriteriaV1> getSearchCriteriaList() {
        return searchCriteriaV1List;
    }
}
