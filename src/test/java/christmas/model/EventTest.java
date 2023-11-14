package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EventTest {
    @ParameterizedTest
    @CsvSource(value = {"WEEKDAY:2023", "WEEKEND:2023", "SPECIAL:1000", "FREEBIE:25000"}, delimiter = ':')
    void 이벤트_할인_가격_판별(Event event, int discountPrice) {
        Assertions.assertThat(event.getDiscountPrice()).isEqualTo(discountPrice);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1000", "2:1100", "25:3400"}, delimiter = ':')
    void 디데이_이벤트_할인_가격_판별(int day, int discountPrice) {
        Assertions.assertThat(Event.D_DAY.getDiscountPrice(day)).isEqualTo(discountPrice);
    }

}
