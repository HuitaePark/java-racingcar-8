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

    @DisplayName("경주 시도 횟수를 숫자로 입력하지 않으면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource({
            "'1회'",
            "'いち'",
            "'四'",
            "'uno'",
            "'one'",
            "'один'",
            "'-1'",
            "'5.5'",
            "'12a3'",
            "''"
    })
    void input_tryCount_is_not_number(String input){
        assertThatThrownBy(() -> InputValidator.validateCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 시도횟수가 들어올경우 에러가 발생하지않는다.")
    @ParameterizedTest
    @CsvSource({
            "1",
            "100",
            "'9999'"
    })
    void input_tryCount_is_success(String input) {
        assertThatCode(() -> InputValidator.validateCount(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("너무 많은 경주 시도 횟수를 숫자로 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource({
            "'9223372036854775808'",
            "'1234567890123456789012345678901234567890'",
            "'999999999999999999999999999999999999999999999999'"
    })
    void input_tryCount_is_big(String input){
        assertThatThrownBy(() -> InputValidator.validateCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
