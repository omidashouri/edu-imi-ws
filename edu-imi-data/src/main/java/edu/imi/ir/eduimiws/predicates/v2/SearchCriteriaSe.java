package edu.imi.ir.eduimiws.predicates.v2;

import java.io.Serializable;
import java.util.Objects;


public class SearchCriteriaSe implements Serializable {

        private static final long serialVersionUID = 6202682331223209100L;

        private String orPredicate;
        private String key;
        private String operation;
        private Object value;
        String prefix;
        String suffix;

        public SearchCriteriaSe(final String orPredicate, final String key, final String operation,
                                final Object value, final String prefix, final String suffix) {
                super();
                this.orPredicate = orPredicate;
                this.key = key;
                this.operation = operation;
                this.value = value;
                this.prefix = prefix;
                this.suffix = suffix;
        }

        public String getOrPredicate() {
                return orPredicate;
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

        public String getPrefix() {
                return prefix;
        }

        public String getSuffix() {
                return suffix;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                SearchCriteriaSe that = (SearchCriteriaSe) o;

                return Objects.equals(orPredicate, that.orPredicate) &&
                        Objects.equals(key, that.key) &&
                        Objects.equals(operation, that.operation) &&
                        Objects.equals(value, that.value) &&
                        Objects.equals(prefix, that.prefix) &&
                        Objects.equals(suffix, that.suffix);
        }

        @Override
        public int hashCode() {
                return Objects.hash(orPredicate, key, operation, value, prefix, suffix);
        }
}
