package edu.imi.ir.eduimiws.specifications.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.specifications.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


@Component
@RequiredArgsConstructor
public class ContactSpecification implements Specification<ContactEntity> {

    private final SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<ContactEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        switch (criteria.getOperation()) {
            case EQUALITY:
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            case NEGATION:
                return criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue());
            case GREATER_THAN:
                return criteriaBuilder.greaterThan(root.<String>get(
                        criteria.getKey()), criteria.getValue().toString());
            case LESS_THAN:
                return criteriaBuilder.lessThan(root.<String>get(
                        criteria.getKey()), criteria.getValue().toString());
            case LIKE:
                return criteriaBuilder.like(root.<String>get(
                        criteria.getKey()), criteria.getValue().toString());
            case STARTS_WITH:
                return criteriaBuilder.like(root.<String>get(criteria.getKey()), criteria.getValue() + "%");
            case ENDS_WITH:
                return criteriaBuilder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue());
            case CONTAINS:
                return criteriaBuilder.like(root.<String>get(
                        criteria.getKey()), "%" + criteria.getValue() + "%");
            default:
                return null;
        }
    }
}
