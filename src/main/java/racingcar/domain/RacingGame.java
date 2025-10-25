package racingcar.domain;

import java.util.List;
import racingcar.domain.strategy.MoveStrategy;


public class RacingGame {

    private final Cars cars;
    private final int tryCount;

    public RacingGame(int tryCount, List<String> userList) {
        this.tryCount = tryCount;
        this.cars = new Cars(userList);
    }

    public String generateResult(MoveStrategy moveStrategy) {
        Race race = new Race(cars,moveStrategy);
        List<String> result = race.playAllRounds(tryCount);

        return String.join("\n\n",result);
    }


    public String findWinners() {
        Referee referee = new Referee(cars);
        Winners winners = referee.judgeWinners();

        return winners.displayNames();
    }

}
