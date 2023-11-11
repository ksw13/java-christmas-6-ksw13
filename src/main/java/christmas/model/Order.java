package christmas.model;

import christmas.util.ExceptionMessage;
import christmas.util.MessageConst;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Order {
    public Order(String order) {
        validate(order);
    }

    private void validate(String order) {
        if (!validFormat(order)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_FORMAT.getMessage());
        }
        validQuantity(order);
    }

    private void validQuantity(String orders) {
        int totalQuantity = Arrays.stream(orders.split(","))
                .map(order -> order.split("-"))
                .mapToInt(order -> Integer.parseInt(order[1]))
                .peek(quantity -> {
                    if (quantity < 1) {
                        throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_QUANTITY.getMessage());
                    }
                })
                .sum();

        if (totalQuantity > 20) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_VALID_TOTAL_QUANTITY.getMessage());
        }
    }

    private boolean validFormat(String order) {
        return Pattern.matches(MessageConst.REGEXP_ORDER_FORMAT, order);
    }
}
