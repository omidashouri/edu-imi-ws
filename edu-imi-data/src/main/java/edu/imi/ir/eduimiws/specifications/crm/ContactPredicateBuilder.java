package edu.imi.ir.eduimiws.specifications.crm;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import edu.imi.ir.eduimiws.specifications.SearchCriteriaOld;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactPredicateBuilder {

    //    private final SearchCriteriaOld searchCriteria;
//    private final List<SearchCriteriaOld> params;
//    = new ArrayList<>();

/*    public ContactPredicateBuilder() {
        params = new ArrayList<>();
    }*/

    public List<SearchCriteriaOld> createListSecrchCriteria(Matcher matcher) {

        List<SearchCriteriaOld> params = new ArrayList<>();
        while (matcher.find()) {
            SearchCriteriaOld searchCriteriaOld = new SearchCriteriaOld();
            searchCriteriaOld.setIsPredicate(matcher.group(1));
            searchCriteriaOld.setKey(matcher.group(2));
            searchCriteriaOld.setOperation(matcher.group(3));
            searchCriteriaOld.setValue(matcher.group(5));
            searchCriteriaOld.setPrefix(matcher.group(4));
            searchCriteriaOld.setSuffix(matcher.group(6));

            if (searchCriteriaOld.getOperation() != null) {
                if (searchCriteriaOld.getOperation().equalsIgnoreCase(":")) {
                    boolean startWithAsterisk = searchCriteriaOld.getPrefix().contains("*");
                    boolean endWithAsterisk = searchCriteriaOld.getSuffix().contains("*");
                    if (startWithAsterisk && endWithAsterisk) {
                        searchCriteriaOld.setOperation("**");
                    } else if (startWithAsterisk) {
                        searchCriteriaOld.setOperation("*_");
                    } else if (endWithAsterisk) {
                        searchCriteriaOld.setOperation("_*");
                    }
                }
            }

            if (searchCriteriaOld.getIsPredicate() != null && searchCriteriaOld.getIsPredicate()
                    .equalsIgnoreCase("'")) {
                searchCriteriaOld.setIsPredicate("1");
            } else {
                searchCriteriaOld.setIsPredicate("0");
            }
            params.add(searchCriteriaOld);
        }
        return params;

 /*       String resultIsPredicate = "0";

        if (operation != null) {
            if (operation.equalsIgnoreCase(":")) {
                boolean startWithAsterisk = prefix.contains("*");
                boolean endWithAsterisk = suffix.contains("*");
                if (startWithAsterisk && endWithAsterisk) {
                    operation = "**";
                } else if (startWithAsterisk) {
                    operation = "*_";
                } else if (endWithAsterisk) {
                    operation = "_*";
                }
            }
        }

        if (orPredicate != null) {
            if (orPredicate.equalsIgnoreCase("'")) {
                resultIsPredicate = "1";
            }
        }
        searchCriteria.setIsPredicate(resultIsPredicate);
        searchCriteria.setKey(key);
        searchCriteria.setOperation(operation);
        searchCriteria.setValue(value);
        params.add(searchCriteria);
        return*/
    }

/*    public ContactPredicateBuilder with(
            String orPredicate, String key, String operation, Object value, String prefix, String suffix) {

        SearchCriteriaOld searchCriteria = new SearchCriteriaOld();
        String resultIsPredicate = "0";

        if (operation != null) {
            if (operation.equalsIgnoreCase(":")) {
                boolean startWithAsterisk = prefix.contains("*");
                boolean endWithAsterisk = suffix.contains("*");
                if (startWithAsterisk && endWithAsterisk) {
                    operation = "**";
                } else if (startWithAsterisk) {
                    operation = "*_";
                } else if (endWithAsterisk) {
                    operation = "_*";
                }
            }
        }

        if (orPredicate != null) {
            if (orPredicate.equalsIgnoreCase("'")) {
                resultIsPredicate = "1";
            }
        }
        searchCriteria.setIsPredicate(resultIsPredicate);
        searchCriteria.setKey(key);
        searchCriteria.setOperation(operation);
        searchCriteria.setValue(value);
        params.add(searchCriteria);
        return this;
    }*/

    public BooleanExpression build(List<SearchCriteriaOld> params) {
        if (params == null || params.size() == 0) {
            return null;
        }


        List<BooleanExpression> orPredicates = params.stream()
                .filter(p -> p.getIsPredicate().equalsIgnoreCase("1"))
                .map(ContactPredicate::new)
                .map(ContactPredicate::getPredicate)
                .collect(Collectors.toList());

        List<BooleanExpression> andPredicates = params.stream()
                .filter(p -> p.getIsPredicate().equalsIgnoreCase("0"))
                .map(ContactPredicate::new)
                .map(ContactPredicate::getPredicate)
                .collect(Collectors.toList());

        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression predicate : andPredicates) {
            result = result.and(predicate);
        }
        for (BooleanExpression predicate : orPredicates) {
            result = result.or(predicate);
        }
/*        List<BooleanExpression> predicates = params.stream()
                .map(param -> {
                    ContactPredicate predicate = new ContactPredicate(param);
                    return predicate.getPredicate();
                }).filter(Objects::nonNull).collect(Collectors.toList());
        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression predicate : predicates) {
            result = result.and(predicate);
        }
        return result;*/
        return result;
    }
}
