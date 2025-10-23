package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("입력받은 이름들로 자동차 객체들을 생성한다.")
    void make_car_list() {
        List<String> inputList = Arrays.asList("김씨", "이씨", "박씨");

        Cars cars = new Cars(inputList);

        assertThat(cars.getCarList())
                .isInstanceOf(List.class)
                .allSatisfy(car -> assertThat(car).isInstanceOf(Car.class));
    }

    @Test
    @DisplayName("입력받은 이름이 중복되어 있으면 에러가 발생한다.")
    void verify_car_name_duplication() {
        List<String> inputList = List.of("김씨", "김씨", "심씨");

        assertThatThrownBy(() -> new Cars(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 이름에 빈 문자열이 포함되면 에러가 발생한다.")
    void verify_car_name_empty() {
        List<String> inputList = Arrays.asList("", "김씨", "심씨");

        assertThatThrownBy(() -> new Cars(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
