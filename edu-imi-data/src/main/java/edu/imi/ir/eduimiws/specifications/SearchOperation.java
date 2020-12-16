package edu.imi.ir.eduimiws.specifications;


public enum SearchOperation {

    EQUALITY, NEGATION, GREATER_THAN, GREATER_THAN_EQUAL, LESS_THAN, LESS_THAN_EQUAL, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS;

    public static final String[] SIMPLE_OPERATION_SET = {":", "!", ">", ">=", "<", "=<", "~"};

    public static SearchOperation getSimpleOperation(char input) {
        switch (input) {
            case ':':
                return EQUALITY;
            case '!':
                return NEGATION;
            case '>':
                return GREATER_THAN;
/*            case '>=':
                return GREATER_THAN_EQUAL;*/
            case '<':
                return LESS_THAN;
/*            case '=<':
                return GREATER_THAN_EQUAL;*/
            case '~':
                return LIKE;
            default:
                return null;
        }
    }
}
