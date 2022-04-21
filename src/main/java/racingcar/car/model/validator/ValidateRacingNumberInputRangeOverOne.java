package racingcar.car.model.validator;

import racingcar.car.GameStatus;

public class ValidateRacingNumberInputRangeOverOne implements Validator {
    private final int INPUT_LIMIT = 1;
    private final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 한다.";

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
