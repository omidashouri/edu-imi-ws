package edu.imi.ir.eduimiws.specifications.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.specifications.CriteriaSpecificationBuilder;
import edu.imi.ir.eduimiws.specifications.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactSpecificationBuilderOld {

    private List<SearchCriteria> params;
    private CriteriaSpecificationBuilder criteriaSpecificationBuilder;

    public Specification<ContactEntity> build() {

        criteriaSpecificationBuilder.params.stream().forEach(params::add);

        if (params.size() == 0) {
            return null;
        }

        Specification result = new ContactSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new ContactSpecification(params.get(i)))
                    : Specification.where(result).and(new ContactSpecification(params.get(i)));
        }

        return result;
    }


}
