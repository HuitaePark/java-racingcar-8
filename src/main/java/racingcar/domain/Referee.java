package racingcar.domain;


public class Referee {

    private final Cars cars;

    public Referee(Cars cars) {
        this.cars = cars;
    }

    public Winners judgeWinners() {
        return cars.getWinners();
    }

}
