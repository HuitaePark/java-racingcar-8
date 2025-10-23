package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.AlwaysMoveStrategy;
import racingcar.domain.strategy.MoveStrategy;

public class RefereeTest {

    @Test
    @DisplayName("제일 많이 진행한 자동차 객체 하나를 찾는다")
    void judge_most_move_car() {
        Queue<Boolean> sequence = new LinkedList<>(List.of(true, false, false));
        MoveStrategy testStrategy = sequence::poll;

        Cars cars = new Cars(List.of("김씨", "박씨", "심씨"));
        cars.moveAll(testStrategy);

        Referee referee = new Referee(cars);
        String winnerList = referee.findWinners().toString();

        assertThat(winnerList).isEqualTo("김씨");
    }

    @Test
    @DisplayName("제일 많이 진행한 자동차가 여러대일 경우 여러개를 찾는다")
    void many_winning_cars() {
        Cars cars = new Cars(List.of("김씨", "박씨", "심씨"));
        cars.moveAll(new AlwaysMoveStrategy());

        Referee referee = new Referee(cars);
        String winnerList = referee.findWinners().toString();

        assertThat(winnerList).isEqualTo("김씨,박씨,심씨");
    }
}
