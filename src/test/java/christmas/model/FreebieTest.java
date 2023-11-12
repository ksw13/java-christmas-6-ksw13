package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FreebieTest {
    @ParameterizedTest
    @CsvSource(value = {"123000:샴페인 1개", "1230:없음"}, delimiter = ':')
    void 증정상품_있는지_검증(int originalCost, String message) {
        Assertions.assertThat(Freebie.compareCostBaseline(originalCost)).isEqualTo(message);
    }
}
