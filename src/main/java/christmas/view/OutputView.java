package christmas.view;

import christmas.model.Order;
import christmas.model.OriginalCost;
import christmas.model.VisitDay;
import java.text.DecimalFormat;

public class OutputView {
    public static final String START_MSG = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String EVENT_PREVIEW_MSG = "12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String ORDER_MSG = "<주문 메뉴>";
    public static final String ORIGINAL_COST_MSG = "<할인 전 총주문 금액>";

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
        System.out.println(getDecimalFormat(originalCost.getOriginalCost()));
        System.out.println();
    }

    public String getDecimalFormat(int input) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###원");
        return decimalFormat.format(input);
    }
}
