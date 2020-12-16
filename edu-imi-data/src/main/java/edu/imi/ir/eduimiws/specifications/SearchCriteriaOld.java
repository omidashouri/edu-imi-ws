package edu.imi.ir.eduimiws.specifications;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@Getter
@Setter
public class SearchCriteriaOld implements Serializable {

        private static final long serialVersionUID = 6611993213180965240L;

        private String isPredicate;
        private String key;
        private String operation;
        private Object value;
        String prefix;
        String suffix;
}
