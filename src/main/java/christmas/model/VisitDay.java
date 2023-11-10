package christmas.model;

import christmas.util.ExceptionMessage;
import christmas.util.NumberConst;
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
        if (!validRange(visitDay)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE.getMessage());
        }
    }

    private boolean validRange(String visitDay) {
        return NumberConst.FIRST_DAY <= Integer.parseInt(visitDay)
                && Integer.parseInt(visitDay) <= NumberConst.LAST_DAY;
    }

}
