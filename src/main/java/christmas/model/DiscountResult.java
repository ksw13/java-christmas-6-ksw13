package christmas.model;

import christmas.util.MessageConst;
import christmas.util.NumberConst;

public class DiscountResult {
    private int discountResult;
    private VisitDay visitDay;
    private Order order;

    public DiscountResult(VisitDay visitDay, Order order) {
        this.discountResult = 0;
        this.visitDay = visitDay;
        this.order = order;
        calDiscount();
    }

    private void calDiscount() {
        discountResult += calDDayDiscount();
        discountResult += calWeekdayDiscount();
        discountResult += calWeekendDiscount();
        discountResult += calSpecialDiscount();
    }

    public int calDDayDiscount() {
        if (Event.D_DAY.hasDate(visitDay.getVisitDay())) {
            return Event.D_DAY.getDiscountPrice(visitDay.getVisitDay());
        }
        return NumberConst.ZERO;
    }

    public int calSpecialDiscount() {
        if (Event.SPECIAL.hasDate(visitDay.getVisitDay())) {
            return Event.SPECIAL.getDiscountPrice();
        }
        return NumberConst.ZERO;
    }

    public int calWeekdayDiscount() {
        long dessertCount = order.getOrder().keySet().stream()
                .filter(menu -> menu.getType().equals(MessageConst.DESSERT))
                .mapToInt(menu -> order.getOrder().get(menu))
                .sum();

        if (Event.WEEKDAY.hasDate(visitDay.getVisitDay())) {
            return Event.WEEKDAY.getDiscountPrice() * (int) dessertCount;
        }
        return NumberConst.ZERO;
    }

    public int calWeekendDiscount() {
        long mainCount = order.getOrder().keySet().stream()
                .filter(menu -> menu.getType().equals(MessageConst.MAIN))
                .mapToInt(menu -> order.getOrder().get(menu))
                .sum();

        if (Event.WEEKEND.hasDate(visitDay.getVisitDay())) {
            return Event.WEEKEND.getDiscountPrice() * (int) mainCount;
        }
        return NumberConst.ZERO;
    }

}
