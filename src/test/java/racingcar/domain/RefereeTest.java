package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

public class RefereeTest {

    private static MoveStrategy sequenceOf(Boolean... moves) {
        Queue<Boolean> queue = new LinkedList<>(List.of(moves));
        return queue::poll;
    }

    @Test
    @DisplayName("제일 많이 진행한 자동차 객체 하나를 찾는다")
    void judge_most_move_car() {
        MoveStrategy testStrategy = sequenceOf(true, false, false);

        Cars cars = new Cars(List.of("김씨", "박씨", "심씨"));
        cars.moveAll(testStrategy);

        Referee referee = new Referee(cars);
        String winnerList = referee.judgeWinners().displayNames();

        assertThat(winnerList).isEqualTo("김씨");
    }

    @Test
    @DisplayName("제일 많이 진행한 자동차가 여러대일 경우 여러개를 찾는다")
    void many_winning_cars() {
        Cars cars = new Cars(List.of("김씨", "박씨", "심씨"));
        cars.moveAll(()->true);

        Referee referee = new Referee(cars);
        String winnerList = referee.judgeWinners().displayNames();

        assertThat(winnerList).isEqualTo("김씨,박씨,심씨");
    }
}
