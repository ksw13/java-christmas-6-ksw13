package christmas.model;

import christmas.util.MessageConst;
import christmas.util.NumberConst;
import java.util.EnumMap;
import java.util.Map;

public class DiscountResult {
    private Map<Event, Integer> discountResult = new EnumMap<>(Event.class);
    private int totalDiscountCost = NumberConst.ZERO;
    private VisitDay visitDay;
    private Order order;
    private OriginalCost originalCost;

    public DiscountResult(VisitDay visitDay, Order order, OriginalCost originalCost) {
        this.visitDay = visitDay;
        this.order = order;
        this.originalCost = originalCost;
        calDiscount();
        calTotalDiscountCost();
    }

    private void calDiscount() {
        if (originalCost.getOriginalCost() >= NumberConst.MINIMUM_ORDER_COST) {
            calDDayDiscount();
            calWeekdayDiscount();
            calWeekendDiscount();
            calSpecialDiscount();
            calFreebieDiscount();
        }
    }

    public void calFreebieDiscount() {
        if (Freebie.isExistDiscount(originalCost.getOriginalCost())) {
            discountResult.put(Event.FREEBIE, Event.FREEBIE.getDiscountPrice());
        }
    }

    public void calDDayDiscount() {
        if (Event.D_DAY.hasDate(visitDay.getVisitDay())) {
            discountResult.put(Event.D_DAY, Event.D_DAY.getDiscountPrice(visitDay.getVisitDay()));
        }
    }

    public void calSpecialDiscount() {
        if (Event.SPECIAL.hasDate(visitDay.getVisitDay())) {
            discountResult.put(Event.SPECIAL, Event.SPECIAL.getDiscountPrice());
        }
    }

    public void calWeekdayDiscount() {
        long dessertCount = order.getOrder().keySet().stream()
                .filter(menu -> menu.getType().equals(MessageConst.DESSERT))
                .mapToInt(menu -> order.getOrder().get(menu))
                .sum();

        if (Event.WEEKDAY.hasDate(visitDay.getVisitDay())) {
            discountResult.put(Event.WEEKDAY, Event.WEEKDAY.getDiscountPrice() * (int) dessertCount);
        }
    }

    public void calWeekendDiscount() {
        long mainCount = order.getOrder().keySet().stream()
                .filter(menu -> menu.getType().equals(MessageConst.MAIN))
                .mapToInt(menu -> order.getOrder().get(menu))
                .sum();

        if (Event.WEEKEND.hasDate(visitDay.getVisitDay())) {
            discountResult.put(Event.WEEKEND, Event.WEEKEND.getDiscountPrice() * (int) mainCount);
        }
    }

    public void calTotalDiscountCost() {
        totalDiscountCost = discountResult.keySet().stream()
                .mapToInt(event -> discountResult.get(event))
                .sum();
    }

    public int calTotalDiscountCostExcludeFreebie() {
        return discountResult.keySet().stream()
                .filter(event -> !event.equals(Event.FREEBIE))
                .mapToInt(event -> discountResult.get(event))
                .sum();
    }

    @Override
    public String toString() {
        if (discountResult.isEmpty()) {
            return MessageConst.NONE + MessageConst.LINE_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (Event event : discountResult.keySet()) {
            sb.append(
                    event.getName() + " : " + MessageConst.getDiscountDecimalFormat(discountResult.get(event))
                            + MessageConst.LINE_SEPARATOR);
        }
        return sb.toString();
    }

    public int getTotalDiscountCost() {
        return totalDiscountCost;
    }
}
