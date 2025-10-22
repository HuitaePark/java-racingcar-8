package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("4 이상의 값이 나올경우 한칸 진행한다.")
    void car_move_4_amount(){
        Car car = new Car();
        car.move(4);
        assertThat(car.distance()).isEqualTo(1);
    }

    @Test
    @DisplayName("4 미만의 값이 나올경우 진행하지 않는다.")
    void car_dont_move_under_4(){
        Car car = new Car();
        car.move(3);
        assertThat(car.distance()).isEqualTo(0);
    }
}
