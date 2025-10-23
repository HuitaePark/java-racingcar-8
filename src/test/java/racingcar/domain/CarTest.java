package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


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

}
