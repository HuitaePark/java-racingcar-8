package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class Race {

    private final int tryCount;
    private final Cars cars;

    public Race(int tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
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
        this.cars.getCarList()
                .forEach(this::moveIfCanByRandom);
    }

    private void moveIfCanByRandom(Car car) {
        car.move(pickRandomNumber());
    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
