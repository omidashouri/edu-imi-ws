package edu.imi.ir.eduimiws.specifications.crm;

import com.google.common.base.Joiner;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.specifications.SearchCriteria;
import edu.imi.ir.eduimiws.specifications.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactSpecificationBuilder {

    private final List<SearchCriteria> params = new ArrayList<>();

    public ContactSpecificationBuilder with(
            String orPredicate, String key, String operation, Object value, String prefix, String suffix) {

        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) {
                boolean startWithAsterisk = prefix != null && prefix.contains("*");
                boolean endWithAsterisk = suffix != null && suffix.contains("*");

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            boolean isOr = orPredicate != null && orPredicate.equalsIgnoreCase("'");
            params.add(new SearchCriteria(key, op, value, isOr));
        }
        return this;
    }

    public ContactSpecificationBuilder with(
            String key, String operation, Object value, String prefix, String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public ContactSpecificationBuilder with(String search) {
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile(
                "(\\p{Punct}?)(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),",
                Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            this.with(matcher.group(1), matcher.group(2), matcher.group(3),
                    matcher.group(5), matcher.group(4), matcher.group(6));
        }
        return this;
    }

    public Specification<ContactEntity> build() {
        if (params.isEmpty()) {
            return null;
        }

        Specification<ContactEntity> result = new ContactSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            SearchCriteria criteria = params.get(i);
            result = criteria.isOrPredicate()
                    ? Specification.where(result).or(new ContactSpecification(criteria))
                    : Specification.where(result).and(new ContactSpecification(criteria));
        }

        return result;
    }
}
