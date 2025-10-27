package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegrationTest extends NsTest {
    private final int MOVING_FORWARD = 4;

    @Test
    @DisplayName("이름에 콤마가 들어올 경우 에러 발생")
    void name_is_comma_error() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수가 너무 많을 경우 에러 발생")
    void too_manny_number_is_error() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("막스,르끌레르,노리스,오스카", "9999999999999999999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("단일 자동차일때 정상적으로 작동한다.")
    void worksNormallyWithSingleCar() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output())
                            .contains("pobi : -")
                            .contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }

    @DisplayName("10대의 자동차가 정상적으로 경주를 진행한다")
    @Test
    void worksNormallyWithTenCars() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2,car3,car4,car5,car6,car7,car8,car9,car10", "1");
                    assertThat(output())
                            .contains(
                                    "car1 : -", "car2 : -", "car3 : -", "car4 : -", "car5 : -",
                                    "car6 : -", "car7 : -", "car8 : -", "car9 : -", "car10 : -",
                                    "최종 우승자 :"
                            );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("이름이 5자가 넘어갈 경우 에러 발생")
    void too_long_name_is_error() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("막스 베르스타펜,샤를 르끌레르,오스카 피아스트리,랜도 노리스,알렉산더 알본", "9"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수가 너무 많을 경우 에러 발생")
    void incorrect_number_is_error() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("막스,르끌레르,노리스,오스카", "두번"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("모든 자동차가 공동 우승하는 경우 테스트")
    void allCarsTieForFirstPlace() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output())
                            .contains("pobi : -", "woni : -", "jun : -")
                            .contains("최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("경주 횟수가 0인 경우 정상 진행")
    void raceWithZeroRounds() {
        assertSimpleTest(() -> {
            run("pobi,woni", "0");
            assertThat(output()).contains("최종 우승자 : pobi, woni");
        });
    }

    @Test
    @DisplayName("자동차 이름이 비어있는 경우 에러발생")
    void emptyCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
