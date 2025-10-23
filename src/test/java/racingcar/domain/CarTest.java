package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("4 이상의 값이 나올경우 한칸 진행한다.")
    void car_move_4_amount() {
        Car car = new Car("");

        car.move(4);

        assertThat(car.distance()).isEqualTo(1);
    }

    @Test
    @DisplayName("4 미만의 값이 나올경우 진행하지 않는다.")
    void car_dont_move_under_4() {
        Car car = new Car("");

        car.move(3);

        assertThat(car.distance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 이름이 5자가 넘으면 에러가 발생한다.")
    void car_name_under_5() {
        assertThatThrownBy(() -> new Car("overName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 이름들로 자동차 객체들을 생성한다.")
    void make_car_list(){
        List<String> inputList = List.of("김씨","이씨","박씨");

        Cars cars = new Cars(inputList);

        assertThat(cars.getCarList())
                .isInstanceOf(List.class)
                .allSatisfy(car -> assertThat(car).isInstanceOf(Car.class));
    }

}
