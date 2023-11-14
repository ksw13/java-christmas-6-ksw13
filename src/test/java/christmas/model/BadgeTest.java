package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BadgeTest {
    @ParameterizedTest
    @CsvSource(value = {"123000:산타", "15300:트리", "6230:별", "1230:없음"}, delimiter = ':')
    void 이벤트_배지_판별(int totalDiscountCost, String message) {
        Assertions.assertThat(Badge.compareCostBaseline(totalDiscountCost)).isEqualTo(message);
    }
}
