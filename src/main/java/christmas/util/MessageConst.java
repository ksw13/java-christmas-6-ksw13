package christmas.util;

import java.text.DecimalFormat;

public class MessageConst {
    public static final String REGEXP_ORDER_FORMAT = "([가-힣]+-\\d+,)*[가-힣]+-\\d+";
    public static final String DELIMITER = ",";
    public static final String HYPHEN = "-";
    public static final String BEVERAGE = "음료";
    public static final String DESSERT = "디저트";
    public static final String MAIN = "메인";
    public static final String NONE = "없음";
    public static final String LINE_SEPARATOR = "\n";
    public static final String ZERO_COST = "0원";

    public static String getDiscountDecimalFormat(int input) {
        if (input == NumberConst.ZERO) {
            return ZERO_COST;
        }
        DecimalFormat decimalFormat = new DecimalFormat("-#,###원");
        return decimalFormat.format(input);
    }
}
