package christmas.model;

public class OriginalCost {
    private int originalCost;

    public OriginalCost(Order order) {
        this.originalCost = order.getOriginalCost();
    }

    public int getOriginalCost() {
        return originalCost;
    }
}
