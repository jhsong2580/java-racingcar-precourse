package racingcar.car;


public class Constant {
    public final static String CAR_IS_NOTMATCHING = "";
    public final static String CAR_NAMES_DELIMITER = ",";
    public final static int RANGE_FOR_CAR_MOVING_MIN = 0;
    public final static int RANGE_FOR_CAR_MOVING_MAX = 9;
    public final static String GUIDE_FOR_INPUT_CARNAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final static String GUIDE_FOR_INPUT_RACINGNUMBER = "시도할 횟수는 몇회인가요?";
    public final static String PROGRESS_BAR = "-";
    public final static String PROGRESS_SPLITER = " : ";
    public final static String WINNER_SPLITER = ", ";
    public final static String WINNER_GUIDE = "최종 우승자: ";
    private final static String ERROR_PREFIX = "[ERROR] %s";
    public final static String ERROR_COMMENT_CAR_NAME_LENGTH = String.format(ERROR_PREFIX, "차 이름은 1~5글자여야 합니다.");
    public final static String ERROR_COMMENT_CAR_NAME_COUNT = String.format(ERROR_PREFIX, "최소 한개 이상의 차 이름이 있어야 합니다.");
    public final static String ERROR_COMMENT_RACING_NUMBER_RANGE = String.format(ERROR_PREFIX, "시도 횟수는 양수여야 합니다.");
    public final static String ERROR_COMMENT_RACING_NUMBER_PARSE = String.format(ERROR_PREFIX, "시도 횟수는 숫자여야 합니다.");

}
