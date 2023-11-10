package christmas.controller;

import christmas.view.OutputView;

public class EventController {
    OutputView outputView = new OutputView();

    public void run() {
        outputView.printStartMessage();
    }
}
