package racingcar.car.model.validator;

import racingcar.car.Constant;
import racingcar.car.GameStatus;

public class ValidateCarNameInputSplitResultSizeMoreThanZero implements Validator {

    @Override
    public boolean canValidate(GameStatus gameStatus) {
        return gameStatus == GameStatus.GET_CAR_NAME;
    }

    @Override
    public boolean validate(String input) {
        boolean validateResult = true;
        String[] names = input.trim().split(Constant.CAR_NAMES_DELIMITER);
        if (names.length == 0) {
            validateResult = false;
            System.out.println(Constant.ERROR_COMMENT_CAR_NAME_COUNT);
        }
        return validateResult;
    }
}

