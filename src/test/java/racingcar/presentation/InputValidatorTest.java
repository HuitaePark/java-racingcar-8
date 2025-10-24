package racingcar.presentation;

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

}
