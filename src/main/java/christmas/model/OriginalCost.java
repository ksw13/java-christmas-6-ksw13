package christmas.model;

public class OriginalCost {
    int originalCost;

    public OriginalCost(Order order) {
        this.originalCost = order.getOriginalCost();
    }

    public int getOriginalCost() {
        return originalCost;
    }

    public String getFreebie() {
        return Freebie.compareCostBaseline(originalCost);
    }
}
