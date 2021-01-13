package edu.imi.ir.eduimiws.predicates.v1;

import java.util.Objects;

public class SearchCriteriaV1 {
    private String key;
    private String operation;
    private Object value;

    public SearchCriteriaV1(final String key, final String operation, final Object value) {
        super();
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getOperation() {
        return operation;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCriteriaV1 that = (SearchCriteriaV1) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(operation, that.operation) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, operation, value);
    }
}
