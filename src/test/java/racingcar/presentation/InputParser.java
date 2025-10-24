package racingcar.presentation;

public final class InputParser {

    private static final String RACING_GAME_INPUT_DELIMITER = ",";

    private InputParser() {
    }

    public static String[] parsing(String input) {
        return input.split(RACING_GAME_INPUT_DELIMITER);
    }
}
