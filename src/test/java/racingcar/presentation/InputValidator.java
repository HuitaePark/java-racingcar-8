package racingcar.presentation;

public final class InputValidator {
    private static final String NAME_REGEX = "^[^,]+(,\\s*[^,\\s]+)*$";

    private InputValidator() {
    }

    public static void validateName(String input) {
        verifyNamePattern(input);
    }

    private static void verifyNamePattern(String input) {
        if (!input.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("이름은 쉼표(,)를 제외한 한개 이상, 여러개일 경우 쉼표(,)로 구분해야 합니다.");
        }
    }
}
