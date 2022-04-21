package racingcar.car.model.validator;

import racingcar.car.GameStatus;

public class ValidateRacingNumberIntputCannotParseInteger implements Validator {
    private final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

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
