package christmas.util;

import java.util.regex.Pattern;

public class Validator {
    public static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public static boolean isOnlyNumber(String input) {
        return Pattern.matches(REGEXP_PATTERN_NUMBER, input);
    }
}
