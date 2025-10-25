package racingcar.presentation.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.presentation.util.InputParser;
import racingcar.presentation.util.InputValidator;

public class InputView {

    public List<String> inputNames(){
        String inputText = Console.readLine();
        InputValidator.validateName(inputText);
        return InputParser.parseName(inputText);
    }

    public int inputTryCount(){
        String inputText = Console.readLine();
        InputValidator.validateCount(inputText);
        return InputParser.parseTryCount(inputText);
    }
}
