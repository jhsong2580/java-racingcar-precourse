package racingcar.car.model.validator;

import racingcar.car.Constant;
import racingcar.car.GameStatus;

public class ValidateRacingNumberInputRangeOverOne implements Validator {
    private final int INPUT_LIMIT = 1;

    @Override
    public boolean canValidate(GameStatus gameStatus) {
        return gameStatus == GameStatus.GET_RACING_NUMBER;
    }

    @Override
    public boolean validate(String input) {
        boolean validateResult = true;
        int inputParseInt = Integer.parseInt(input);
        if (inputParseInt < INPUT_LIMIT) {
            System.out.println(Constant.ERROR_COMMENT_RACING_NUMBER_RANGE);
            validateResult = false;
        }
        return validateResult;
    }
}
