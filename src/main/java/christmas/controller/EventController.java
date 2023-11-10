package christmas.controller;

import christmas.model.VisitDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        outputView.printStartMessage();
        VisitDay visitDay = new VisitDay(inputView.inputVisitDay());
    }
}
