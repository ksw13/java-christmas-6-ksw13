package christmas.model;

public enum Freebie {
    CHAMPAGNE(120000, "샴페인 1개"),
    EMPTY(0, "없음");

    private int costBaseline;
    private String message;

    Freebie(int costBaseline, String message) {
        this.costBaseline = costBaseline;
        this.message = message;
    }

    public static String compareCostBaseline(int originalCost) {
        if (CHAMPAGNE.costBaseline <= originalCost) {
            return CHAMPAGNE.message;
        }
        return EMPTY.message;
    }

    public static boolean isExistDiscount(int originalCost) {
        return CHAMPAGNE.costBaseline <= originalCost;
    }
}
