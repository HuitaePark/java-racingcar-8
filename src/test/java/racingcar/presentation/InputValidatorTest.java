package racingcar.presentation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputValidatorTest {

    @DisplayName("쉼표로 구분되지 않은 이름들이 들어올경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource({
            "',이름'",
            "'이름,'",
            "'이름,,이름'"
    })
    void input_validate_separation_by_comma(String input) {
        assertThatThrownBy(() -> InputValidator.validateName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 이름이 들어올경우 에러가 발생하지않는다.")
    @ParameterizedTest
    @CsvSource({
            "pobi",
            "박희태,1234,abc-_-def",
            "'이름1, 이름2, 이름3'"
    })
    void input_separation_success_by_comma(String input) {
        assertThatCode(() -> InputValidator.validateName(input))
                .doesNotThrowAnyException();
    }

}
