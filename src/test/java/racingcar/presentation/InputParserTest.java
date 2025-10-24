package racingcar.presentation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputParserTest {

    @Test
    @DisplayName("입력값이 들어오면 쉼표로 이름을 구분해서 반환한다.")
    void input_split_by_comma() {
        String input = "pobi,woni,jun";

        assertThat(new String[]{"pobi", "woni", "jun"}).isEqualTo(InputParser.parsing(input));
    }


    @DisplayName("쉼표로 구분되지 않은 이름들이 들어올경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource({
            "',이름'",
            "'이름,'",
            "'이름,,이름'"
    })
    void input_validate_separation_by_comma(String input) {
        assertThatThrownBy(() -> {
            String[] parse = InputParser.parsing(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
