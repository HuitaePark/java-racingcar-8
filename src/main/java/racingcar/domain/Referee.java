package racingcar.domain;


public class Referee {

    private final Cars cars;

    public Referee(Cars cars) {
        this.cars = cars;
    }

    public Winners findWinners() {
        return cars.findWinners();
    }

}
