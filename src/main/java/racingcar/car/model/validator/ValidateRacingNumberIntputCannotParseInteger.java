package racingcar.car.model.validator;

import racingcar.car.GameStatus;
import racingcar.car.constant.ErrorMessageConstant;

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
            System.out.println(ErrorMessageConstant.ERROR_COMMENT_RACING_NUMBER_PARSE);
        }
        return validateResult;
    }
}
