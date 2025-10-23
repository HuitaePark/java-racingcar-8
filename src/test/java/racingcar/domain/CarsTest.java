package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("입력받은 이름들로 자동차 객체들을 생성한다.")
    void make_car_list() {
        List<String> inputList = List.of("김씨", "이씨", "박씨");

        Cars cars = new Cars(inputList);

        assertThat(cars.getCarList())
                .isInstanceOf(List.class)
                .allSatisfy(car -> assertThat(car).isInstanceOf(Car.class));
    }
}
