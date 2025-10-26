package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

class RacingGameTest {

    @Test
    @DisplayName("모든 자동차가 항상 이동하는 전략일 경우, 시도 횟수만큼 전진 결과가 나온다")
    void generateResult_withAlwaysMoveStrategy() {
        // given
        List<String> userList = List.of("pobi", "crong");
        int tryCount = 3;
        RacingGame racingGame = new RacingGame(tryCount, userList);
        MoveStrategy alwaysMove = () -> true;

        // when
        String result = racingGame.run(alwaysMove);

        // then
        String[] lines = result.split("\n");
        assertThat(lines).contains(
                "pobi : ---",
                "crong : ---"
        );
    }

    @Test
    @DisplayName("모든 자동차가 절대 이동하지 않는 전략일 경우, 초기 위치 그대로 남는다")
    void generateResult_withNeverMoveStrategy() {
        // given
        List<String> userList = List.of("pobi", "crong");
        int tryCount = 2;
        RacingGame racingGame = new RacingGame(tryCount, userList);
        MoveStrategy neverMove = () -> false;

        // when
        String result = racingGame.run(neverMove);

        // then
        String[] lines = result.split("\n");
        assertThat(lines).contains(
                "pobi : ",
                "crong : "
        );
    }

    @Test
    @DisplayName("Referee를 통해 우승자를 반환한다")
    void findWinners_returnsExpectedNames() {
        // given
        List<String> userList = List.of("pobi", "crong");
        RacingGame racingGame = new RacingGame(1, userList);
        MoveStrategy alwaysMove = () -> true;

        racingGame.run(alwaysMove);

        // when
        String winners = racingGame.findWinners();

        // then
        assertThat(winners).isEqualTo("pobi,crong");
    }
}
