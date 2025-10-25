package racingcar.presentation.ui;

public class OutputView {
    private final static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private final static String ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?\n";
    private final static String GAME_RESULT_MESSAGE = "실행 결과";
    private final static String WINNER_MESSAGE = "최종 우승자 : %s";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printAskTryCountMessage() {
        System.out.println(ASK_TRY_COUNT);
    }

    public static void printGameResult(String result) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(result);
    }

    public static void printGameWinners(String winners) {
        System.out.printf(WINNER_MESSAGE, winners);
    }
}
