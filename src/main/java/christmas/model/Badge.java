package christmas.model;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    
    ETC("없음", 0);

    private String name;
    private int costBaseline;

    Badge(String name, int costBaseline) {
        this.name = name;
        this.costBaseline = costBaseline;
    }

    public static String compareCostBaseline(int totalDiscountCost) {
        if (SANTA.costBaseline <= totalDiscountCost) {
            return SANTA.name;
        }
        if (TREE.costBaseline <= totalDiscountCost) {
            return TREE.name;
        }
        if (STAR.costBaseline <= totalDiscountCost) {
            return STAR.name;
        }
        return ETC.name;
    }

}
