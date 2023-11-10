package christmas.model;

import christmas.util.ExceptionMessage;
import christmas.util.MessageConst;
import java.util.regex.Pattern;

public class Order {
    public Order(String order) {
        validate(order);
    }

    private void validate(String order) {
        if (!validFormat(order)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_FORMAT.getMessage());
        }
    }

    private boolean validFormat(String order) {
        return Pattern.matches(MessageConst.REGEXP_ORDER_FORMAT, order);
    }
}
