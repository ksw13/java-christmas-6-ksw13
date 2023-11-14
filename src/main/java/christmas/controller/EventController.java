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
    OriginalCost originalCost;
    DiscountResult discountResult;

    public void run() {
        order();
        
        orderResult();

        promotionResult();
    }

    private void promotionResult() {
        outputView.printFreebie(originalCost);
        discountResult = new DiscountResult(visitDay, order, originalCost);
        outputView.printDiscount(discountResult);
        outputView.printTotalDiscountCost(discountResult);
        outputView.printExpectedPaymentCost(originalCost, discountResult);
        outputView.printBadge(discountResult);
    }

    private void orderResult() {
        outputView.printEventPreviewMessage(visitDay);
        outputView.printOrders(order);
        originalCost = new OriginalCost(order);
        outputView.printOriginalCost(originalCost);
    }

    private void order() {
        outputView.printStartMessage();
        createVisitDay();
        createOrder();
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
