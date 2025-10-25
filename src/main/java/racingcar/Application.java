package racingcar;

import racingcar.presentation.controller.RacingGameController;
import racingcar.presentation.ui.InputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController(new InputView());
        controller.startGame();
    }
}
