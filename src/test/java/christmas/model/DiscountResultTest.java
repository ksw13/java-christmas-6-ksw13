package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountResultTest {
    DiscountResult discountResult;

    @BeforeEach
    void setUp() {
        VisitDay visitDay = new VisitDay("25");
        Order order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,아이스크림-4,제로콜라-1");
        discountResult = new DiscountResult(visitDay, order);
    }

    @Test
    public void 크리스마스_디데이_할인_검증() {
        Assertions.assertThat(discountResult.calDDayDiscount()).isEqualTo(3400);
    }

    @Test
    public void 평일_할인_검증() {
        Assertions.assertThat(discountResult.calWeekdayDiscount()).isEqualTo(2023 * 6);
    }

    @Test
    public void 주말_할인_검증() {
        Assertions.assertThat(discountResult.calWeekendDiscount()).isEqualTo(0);
    }

    @Test
    public void 특별_할인_검증() {
        Assertions.assertThat(discountResult.calSpecialDiscount()).isEqualTo(1000);

    }


}
