package racingcar.domain;

import java.util.List;

public class Referee {

    private final List<Car> carList;

    public Referee(Cars cars) {
        this.carList = cars.getCarList();
    }

    public Winners findWinners() {
        return new Winners(
                carList.stream()
                        .filter(car -> car.distance() == getTopPosition())
                        .map(Car::getName)
                        .toList()
        );
    }

    private int getTopPosition() {
        return carList.stream()
                .mapToInt(Car::distance)
                .max()
                .orElse(0);
    }
}
