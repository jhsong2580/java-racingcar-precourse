package racingcar.car.model.validator;

import racingcar.car.Constant;
import racingcar.car.GameStatus;

public class ValidateRacingNumberIntputCannotParseInteger implements Validator {

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
            System.out.println(Constant.ERROR_COMMENT_RACING_NUMBER_PARSE);
        }
        return validateResult;
    }
}
