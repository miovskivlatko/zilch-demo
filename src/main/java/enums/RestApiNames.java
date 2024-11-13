package enums;

import java.util.HashMap;
import java.util.Map;

public enum RestApiNames {
    /**
     * Using RestAPI Names as Enum list
     */

    TEST("test"),
    UAT("uat");

    public final String option;

    RestApiNames(String option) {

        this.option = option;
    }
}
