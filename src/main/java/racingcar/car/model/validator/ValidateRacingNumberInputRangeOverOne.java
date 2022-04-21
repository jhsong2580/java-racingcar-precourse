package racingcar.car.model.validator;

import racingcar.car.GameStatus;
import racingcar.car.error.Error;

public class ValidateRacingNumberInputRangeOverOne implements Validator {
    private final int INPUT_LIMIT = 1;
    private final String ERROR_MESSAGE = Error.createErrorComment("시도 횟수는 양수여야 합니다.");

    @Override
    public boolean canValidate(GameStatus gameStatus) {
        return gameStatus == GameStatus.GET_RACING_NUMBER;
    }

    @Override
    public boolean validate(String input) {
        boolean validateResult = true;
        int inputParseInt = Integer.parseInt(input);
        if (inputParseInt < INPUT_LIMIT) {
            System.out.println(ERROR_MESSAGE);
            validateResult = false;
        }
        return validateResult;
    }
}
