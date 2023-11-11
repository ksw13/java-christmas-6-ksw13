package christmas.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.util.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {
    @ParameterizedTest
    @ValueSource(strings = {"시저샐러드-1,티본스테이크-1,", "시저샐러드-1-", "시저샐러드-1, 티본스테이크", "123",
            "시저샐러드-1개"})
    void 주문이_올바른_형식인지_검증(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_VALID_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-0,바비큐립-1,초코케이크-2,제로콜라-1", "시저샐러드-0"})
    void 메뉴의_개수가_양의정수가_맞는지_검증(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_VALID_QUANTITY.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"시저샐러드-11,티본스테이크-10"})
    void 메뉴의_총개수가_20이_넘는지_검증(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_VALID_TOTAL_QUANTITY.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"비빔밥-1,떡볶이-2", "불고기-3,참치김밥-2"})
    void 주문한_메뉴가_메뉴판에_있는지_검증(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_CONTAIN_MENU.getMessage());
    }


}
