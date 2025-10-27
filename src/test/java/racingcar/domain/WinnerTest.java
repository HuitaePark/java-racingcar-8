package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Winners;

public class WinnerTest {
    @Test
    @DisplayName("우승자 목록을 받아서 쉼표로 구분해 출력한다.")
    void many_winning_cars() {
        Winners winners = new Winners(List.of("김씨", "박씨", "심씨"));

        assertThat(winners.displayNames()).isEqualTo("김씨, 박씨, 심씨");
    }
}
