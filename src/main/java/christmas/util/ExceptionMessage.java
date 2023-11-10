package christmas.util;

public enum ExceptionMessage {
    NOT_NUMBER("입력값은 숫자만 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
