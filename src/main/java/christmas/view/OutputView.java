package christmas.view;

import christmas.model.Badge;
import christmas.model.DiscountResult;
import christmas.model.Freebie;
import christmas.model.Order;
import christmas.model.OriginalCost;
import christmas.model.VisitDay;
import christmas.util.MessageConst;
import java.text.DecimalFormat;

public class OutputView {
    public static final String START_MSG = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String EVENT_PREVIEW_MSG = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String ORDER_MSG = "<주문 메뉴>";
    public static final String ORIGINAL_COST_MSG = "<할인 전 총주문 금액>";
    public static final String FREEBIE_MSG = "<증정 메뉴>";
    public static final String DISCOUNT_MSG = "<혜택 내역>";
    public static final String TOTAL_DISCOUNT_MSG = "<총혜택 금액>";
    public static final String EXPECTED_PAYMENT_MSG = "<할인 후 예상 결제 금액>";
    public static final String BADGE_MSG = "<12월 이벤트 배지>";

    public void printStartMessage() {
        System.out.println(START_MSG);
    }

    public void printEventPreviewMessage(VisitDay visitDay) {
        System.out.println(String.format(EVENT_PREVIEW_MSG, visitDay.getVisitDay()));
        System.out.println();
    }

    public void printOrders(Order order) {
        System.out.println(ORDER_MSG);
        System.out.println(order.toString());
    }

    public void printOriginalCost(OriginalCost originalCost) {
        System.out.println(ORIGINAL_COST_MSG);
        System.out.println(getCostDecimalFormat(originalCost.getOriginalCost()));
        System.out.println();
    }

    public void printFreebie(OriginalCost originalCost) {
        System.out.println(FREEBIE_MSG);
        System.out.println(Freebie.compareCostBaseline(originalCost.getOriginalCost()));
        System.out.println();
    }

    public void printDiscount(DiscountResult discountResult) {
        System.out.println(DISCOUNT_MSG);
        System.out.println(discountResult.toString());
    }

    public void printTotalDiscountCost(DiscountResult discountResult) {
        System.out.println(TOTAL_DISCOUNT_MSG);
        System.out.println(MessageConst.getDiscountDecimalFormat(discountResult.getTotalDiscountCost()));
        System.out.println();
    }

    public void printExpectedPaymentCost(OriginalCost originalCost, DiscountResult discountResult) {
        System.out.println(EXPECTED_PAYMENT_MSG);
        System.out.println(
                getCostDecimalFormat(
                        originalCost.getOriginalCost() - discountResult.calTotalDiscountCostExcludeFreebie()));
        System.out.println();
    }

    public void printBadge(DiscountResult discountResult) {
        System.out.println(BADGE_MSG);
        System.out.println(Badge.compareCostBaseline(discountResult.getTotalDiscountCost()));
    }

    public String getCostDecimalFormat(int input) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###원");
        return decimalFormat.format(input);
    }
}
