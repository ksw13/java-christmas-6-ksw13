package christmas.model;

import christmas.util.ExceptionMessage;
import christmas.util.MessageConst;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Order {
    Map<Menu, Integer> order = new EnumMap<>(Menu.class);

    public Order(String orders) {
        validate(orders);
        Map<Menu, Integer> temporaryStorage = new EnumMap<>(Menu.class);
        String[] order = orders.split(MessageConst.DELIMITER);
        for (String menu : order) {
            String name = menu.split(MessageConst.HYPHEN)[0];
            int quantity = Integer.parseInt(menu.split(MessageConst.HYPHEN)[1]);
            temporaryStorage.put(getMenu(name), quantity);
        }
        validExistOnlyBeverage(temporaryStorage);
    }

    private void validExistOnlyBeverage(Map<Menu, Integer> map) {
        boolean isOnlyBeverage = map.keySet().stream()
                .allMatch(menu -> menu.getType().equals(MessageConst.BEVERAGE));
        if (isOnlyBeverage) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_BEVERAGE.getMessage());
        }
    }

    private Menu getMenu(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_CONTAIN_MENU.getMessage()));
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

    public Map<Menu, Integer> getOrder() {
        return order;
    }
}
