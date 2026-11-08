package edu.imi.ir.eduimiws.specifications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {

    private String key;
    private SearchOperation operation;
    private Object value;
    private boolean orPredicate;

    public SearchCriteria(String key, SearchOperation operation, Object value) {
        this(key, operation, value, false);
    }

    public boolean isOrPredicate() {
        return orPredicate;
    }
}
