package racingcar.presentation;

public final class InputParser {

    private static final String RACING_GAME_INPUT_DELIMITER = ",";
    private static final String NAME_REGEX = "^[^,]+(,\\s*[^,\\s]+)*$";

    private InputParser() {
    }

    public static String[] parsing(String input) {
        verifyNamePattern(input);
        return input.split(RACING_GAME_INPUT_DELIMITER);
    }

    private static void verifyNamePattern(String input) {
        if (!input.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("이름은 쉼표(,)를 제외한 한개 이상, 여러개일 경우 쉼표(,)로 구분해야 합니다.");
        }
    }
}
