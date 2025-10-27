package racingcar.presentation.ui.util;

import java.math.BigInteger;

public final class InputValidator {
    private static final String NAME_REGEX = "^[^,]+(,\\s*[^,\\s]+)*$";
    private static final String COUNT_REGEX = "\\d+";

    private InputValidator() {
    }

    public static void verifyNamePattern(String input) {
        if (!input.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("이름은 쉼표(,)를 제외한 한개 이상, 여러개일 경우 쉼표(,)로 구분해야 합니다.");
        }
    }

    public static void validateCount(String input) {
        verifyCount(input);
        verifyNumberRange(input);
    }

    private static void verifyCount(String input) {
        if (!input.matches(COUNT_REGEX)) {
            throw new IllegalArgumentException("시도 횟수는 숫자를 입력하셔야 합니다.");
        }
    }

    private static void verifyNumberRange(String input) {
        BigInteger value = new BigInteger(input);
        BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);

        if (isBiggerThanInt(value,max)) {
            throw new IllegalArgumentException("너무 많은 수는 입력할 수 없습니다.");
        }
    }

    private static boolean isBiggerThanInt(BigInteger value, BigInteger max){
        return value.compareTo(max) > 0;
    }

}
