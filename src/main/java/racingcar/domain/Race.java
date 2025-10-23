package racingcar.domain;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.strategy.MoveStrategy;

public class Race {

    private final int tryCount;
    private final Cars cars;
    private final MoveStrategy strategy;

    public Race(int tryCount, Cars cars, MoveStrategy strategy) {
        this.tryCount = tryCount;
        this.cars = cars;
        this.strategy = strategy;
    }

    public List<String> playAllRounds() {
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
