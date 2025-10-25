package racingcar.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputParserTest {

    @Test
    @DisplayName("입력값이 들어오면 쉼표로 이름을 구분해서 반환한다.")
    void input_split_by_comma() {
        String input = "pobi,woni,jun";

        assertThat(Arrays.asList("pobi", "woni", "jun")).isEqualTo(InputParser.parseName(input));
    }

    @Test
    @DisplayName("입력값이 들어오면 시도횟수 int로 반환한다.")
    void input_parse_int_by_input() {
        String input = "5";

        assertThat(5).isEqualTo(InputParser.parseTryCount(input));
    }
}
