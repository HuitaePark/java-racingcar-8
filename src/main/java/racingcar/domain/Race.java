package racingcar.domain;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.strategy.MoveStrategy;

public class Race {

    private final Cars cars;
    private final MoveStrategy strategy;

    public Race(Cars cars, MoveStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public List<String> playAllRounds(int tryCount) {
        return IntStream.range(0,tryCount)
                .mapToObj(i->recordRound())
                .toList();
    }

    private String recordRound() {
        playRound();
        return cars.getRoundResult();
    }

    private void playRound() {
        cars.moveAll(strategy);
    }

}
