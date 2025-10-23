package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> inputList) {
        verifyDuplicationName(inputList);
        this.carList = convertFrom(inputList);
    }

    public List<Car> getCarList() {
        return carList;
    }

    private List<Car> convertFrom(List<String> inputList) {
        return inputList.stream()
                .map(Car::new)
                .toList();
    }

    private void verifyDuplicationName(List<String> inputList) {
        if (inputList.size() != getDistinctSize(inputList)) {
            throw new IllegalArgumentException();
        }
    }

    private int getDistinctSize(List<String> inputList) {
        return (int) inputList.stream()
                .distinct()
                .count();
    }
}
