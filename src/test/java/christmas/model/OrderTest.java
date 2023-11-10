package christmas.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.util.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {
    @ParameterizedTest
    @ValueSource(strings = {"시저샐러드-1, 티본스테이크-1,", "시저샐러드-1-", "시저샐러드-1, 티본스테이크-110", "시저샐러드-1, 티본스테이크", "123",
            "시저샐러드-1개"})
    void 주문이_올바른_형식인지_검증(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_VALID_FORMAT.getMessage());
    }

}
