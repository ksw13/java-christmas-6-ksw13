package christmas.controller;

import christmas.model.DiscountResult;
import christmas.model.Order;
import christmas.model.OriginalCost;
import christmas.model.VisitDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    VisitDay visitDay;
    Order order;

    public void run() {
        outputView.printStartMessage();
        createVisitDay();
        createOrder();

        outputView.printEventPreviewMessage(visitDay);
        outputView.printOrders(order);

        OriginalCost originalCost = new OriginalCost(order);
        outputView.printOriginalCost(originalCost);
        outputView.printFreebie(originalCost);
        DiscountResult discountResult = new DiscountResult(visitDay, order, originalCost);
        outputView.printDiscount(discountResult);
        outputView.printTotalDiscountCost(discountResult);
        outputView.printExpectedPaymentCost(originalCost, discountResult);
        outputView.printBadge(discountResult);
    }

    private void createOrder() {
        try {
            order = new Order(inputView.inputOrder());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            createOrder();
        }
    }

    private void createVisitDay() {
        try {
            visitDay = new VisitDay(inputView.inputVisitDay());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            createVisitDay();
        }
    }
}
