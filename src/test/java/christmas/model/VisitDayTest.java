package christmas.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.util.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDayTest {

    @ParameterizedTest
    @ValueSource(strings = {"2a", "aaa", "3333a"})
    void 방문날짜가_숫자로만_이루어져_있는지_검증(String input) {
        assertThatThrownBy(() -> new VisitDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "32"})
    void 방문날짜가_유효한_범위인지_검증(String input) {
        assertThatThrownBy(() -> new VisitDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_IN_RANGE.getMessage());
    }
}
