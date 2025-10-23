package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> inputList) {
        this.carList = convertFrom(inputList);
    }

    public List<Car> getCarList() {
        return carList;
    }

    private List<Car> convertFrom(List<String> inputList){
        return inputList.stream()
                .map(Car::new)
                .toList();
    }
}
