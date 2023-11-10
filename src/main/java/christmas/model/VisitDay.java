package christmas.model;

import christmas.util.ExceptionMessage;
import christmas.util.Validator;

public class VisitDay {
    private int visitDay;

    public VisitDay(String visitDay) {
        validate(visitDay);
        this.visitDay = Integer.parseInt(visitDay);
    }

    private void validate(String visitDay) {
        if (!Validator.isOnlyNumber(visitDay)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER.getMessage());
        }
    }
}
