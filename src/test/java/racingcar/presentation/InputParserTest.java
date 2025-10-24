package racingcar.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputParserTest {
    @Test

    void input_split_by_comma(){
        String input = "pobi,woni,jun";
        assertThat(input.split(",")).isEqualTo(InputParser.parsing(input));
    }
}
