package racingcar.presentation;

import java.util.Arrays;
import java.util.List;

public final class InputParser {

    private static final String RACING_GAME_INPUT_DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parseName(String input) {
        return Arrays.asList(input.split(RACING_GAME_INPUT_DELIMITER));
    }

    public static int parseTryCount(String input){
        return Integer.parseInt(input);
    }

}
