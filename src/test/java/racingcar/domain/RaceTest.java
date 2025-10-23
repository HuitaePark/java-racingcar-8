package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.RandomMoveStrategy;

public class RaceTest {

    @Test
    @DisplayName("입력 받은 만큼 경주를 진행시킨다.")
    void make_race_session() {
        List<String> inputList = List.of("김씨", "이씨", "심씨");

        int tryCount = 3;

        Race race = new Race(new Cars(inputList),new RandomMoveStrategy());

        assertThat(race.playAllRounds(3))
                .hasSize(tryCount);
    }
}
