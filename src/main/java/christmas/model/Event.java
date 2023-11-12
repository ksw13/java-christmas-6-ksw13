package christmas.model;

import java.util.Arrays;
import java.util.List;

public enum Event {
    D_DAY("크리스마스 디데이 할인",
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25),
            1000),
    WEEKDAY("평일 할인", Arrays.asList(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31),
            2023),
    WEEKEND("주말 할인", Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30), 2023),
    SPECIAL("특별 할인", Arrays.asList(3, 10, 17, 24, 25, 31), 1000),
    FREEBIE("증정 이벤트", Arrays.asList(), 25000);


    private String name;
    private List<Integer> discountDate;
    private int discountPrice;

    Event(String name, List<Integer> discountDate, int discountPrice) {
        this.name = name;
        this.discountDate = discountDate;
        this.discountPrice = discountPrice;
    }

    public boolean hasDate(int day) {
        return discountDate.contains(day);
    }

    public int getDiscountPrice(int day) {
        if (this == D_DAY) {
            return discountPrice + (100 * (day - 1));
        }
        return discountPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public String getName() {
        return name;
    }
}
