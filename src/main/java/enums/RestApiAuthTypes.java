package enums;

public enum RestApiAuthTypes {
    /**
     * Using RestAPI Authorization as Enum list
     * Authorization is used in request's header
     */

    WITHOUT("None"),
    BASIC_AUTH("Basic-Auth"),
    TOKEN_AUTH("Token-Auth");

    public final String option;

    RestApiAuthTypes(String option) {

        this.option = option;
    }
}
