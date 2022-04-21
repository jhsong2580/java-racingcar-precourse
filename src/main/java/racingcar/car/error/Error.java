package racingcar.car.error;

public class Error {
    private static final String ERROR_FORMAT = "[ERROR] %s";

    public static String createErrorComment(String comment) {
        return String.format(ERROR_FORMAT, comment);
    }
}
