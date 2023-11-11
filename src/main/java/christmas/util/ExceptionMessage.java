package christmas.util;

public enum ExceptionMessage {
    NOT_NUMBER("입력값은 숫자만 가능합니다."),
    NOT_IN_RANGE("유효하지 않은 날짜입니다."),
    NOT_VALID_FORMAT("유효하지 않은 주문입니다."),
    NOT_VALID_QUANTITY("유효하지 않은 주문입니다."),
    NOT_VALID_TOTAL_QUANTITY("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    NOT_CONTAIN_MENU("유효하지 않은 주문입니다."),
    ONLY_BEVERAGE("음료만 주문 시, 주문할 수 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s 다시 입력해 주세요.";
    private String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
