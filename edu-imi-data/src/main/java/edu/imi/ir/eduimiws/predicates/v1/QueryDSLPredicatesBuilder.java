package edu.imi.ir.eduimiws.predicates.v1;

import com.google.common.base.Joiner;
import com.querydsl.core.types.dsl.BooleanExpression;
import edu.imi.ir.eduimiws.exceptions.QueryDSLPredicateBuildException;
import edu.imi.ir.eduimiws.specifications.SearchOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryDSLPredicatesBuilder<T> {
    private final List<SearchCriteria> searchCriteriaList;
    private final Class<T> entityClass;

    public QueryDSLPredicatesBuilder(Class<T> entityClass) {
        this.searchCriteriaList = new ArrayList<>();
        this.entityClass = entityClass;
    }

    public QueryDSLPredicatesBuilder with(final String key, final String operation, final Object value) {
        searchCriteriaList.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public QueryDSLPredicatesBuilder with(final String search) {
        Pattern pattern = Pattern.compile("([^,]+)([:;!<>])([^,]+)");
        Matcher matcher = pattern.matcher(search);
        while (matcher.find()) {
            this.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        return this;
    }

    public QueryDSLPredicatesBuilder withSearchString(final String search) {
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
        if (searchCriteriaList.size() == 0) {
            return null;
        }

        final List<BooleanExpression> predicates = new ArrayList<>();
        QueryDSLPredicate<T> predicate;
        for (final SearchCriteria param : searchCriteriaList) {
            predicate = new QueryDSLPredicate<>(param);
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

    public List<SearchCriteria> getSearchCriteriaList() {
        return searchCriteriaList;
    }
}
