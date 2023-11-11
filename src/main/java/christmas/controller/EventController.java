package christmas.controller;

import christmas.model.Order;
import christmas.model.OriginalCost;
import christmas.model.VisitDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        outputView.printStartMessage();
        VisitDay visitDay = new VisitDay(inputView.inputVisitDay());
        Order order = new Order(inputView.inputOrder());

        outputView.printEventPreviewMessage(visitDay);
        outputView.printOrders(order);

        OriginalCost originalCost = new OriginalCost(order);
        outputView.printOriginalCost(originalCost);
    }
}
