package racingcar.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> inputList) {
        validate(inputList);
        this.carList = convertFrom(inputList);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveAll(MoveStrategy strategy) {
        carList.forEach(car -> car.move(strategy));
    }

    public String getRoundResult() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    private List<Car> convertFrom(List<String> inputList) {
        return inputList.stream()
                .map(Car::new)
                .toList();
    }

    public Winners getWinners() {
        return new Winners(
                carList.stream()
                        .filter(car -> car.distance() == getTopPosition())
                        .map(Car::getName)
                        .toList()
        );
    }

    private void validate(List<String> inputList) {
        verifyDuplicationName(inputList);
        verifyEmptyName(inputList);
    }

    private void verifyDuplicationName(List<String> inputList) {
        if (inputList.size() != getDistinctSize(inputList)) {
            throw new IllegalArgumentException();
        }
    }

    private int getDistinctSize(List<String> inputList) {
        return (int) inputList.stream().distinct().count();
    }

    private void verifyEmptyName(List<String> inputList) {
        if (inputList.contains("")) {
            throw new IllegalArgumentException();
        }
    }

    private int getTopPosition() {
        return carList.stream()
                .mapToInt(Car::distance)
                .max()
                .orElse(0);
    }

}
