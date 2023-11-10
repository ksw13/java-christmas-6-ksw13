package christmas.util;

public enum ExceptionMessage {
    NOT_NUMBER("입력값은 숫자만 가능합니다."),
    NOT_IN_RANGE("유효하지 않은 날짜입니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s 다시 입력해 주세요.";
    private String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
