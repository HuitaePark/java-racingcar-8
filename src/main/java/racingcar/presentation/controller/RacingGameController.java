package racingcar.presentation.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.presentation.ui.InputView;
import racingcar.presentation.ui.OutputView;

public class RacingGameController {

    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void startGame() {
        List<String> userList = readUserNames();
        int tryCount = readTryCount();

        RacingGame racingGame = new RacingGame(tryCount, userList);
        printResults(racingGame);
        inputView.closeConsole();
    }

    private List<String> readUserNames() {
        OutputView.printStartMessage();
        return inputView.inputNames();
    }

    private int readTryCount() {
        OutputView.printAskTryCountMessage();
        return inputView.inputTryCount();
    }

    private void printResults(RacingGame racingGame) {
        OutputView.printGameResult(racingGame.generateResult());
        OutputView.printGameWinners(racingGame.findWinners());
    }

}
