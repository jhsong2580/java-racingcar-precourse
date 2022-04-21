package racingcar.car.model.validator;

import racingcar.car.GameStatus;
import racingcar.car.error.Error;

public class ValidateRacingNumberIntputCannotParseInteger implements Validator {
    private final String ERROR_MESSAGE = Error.createErrorComment("시도 횟수는 숫자여야 합니다.");

    @Override
    public boolean canValidate(GameStatus gameStatus) {
        return gameStatus == GameStatus.GET_RACING_NUMBER;
    }

    @Override
    public boolean validate(String input) {
        boolean validateResult = true;
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            validateResult = false;
            System.out.println(ERROR_MESSAGE);
        }
        return validateResult;
    }
}
