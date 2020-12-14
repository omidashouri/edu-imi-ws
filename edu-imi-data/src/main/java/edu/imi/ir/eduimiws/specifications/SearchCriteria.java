package edu.imi.ir.eduimiws.specifications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SearchCriteria {

    private String key;
    private SearchOperation operation;
    private Object value;

    public boolean isOrPredicate() {
        return false;
    }
}
