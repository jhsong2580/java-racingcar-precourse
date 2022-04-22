package racingcar.car.model.validator;

import racingcar.car.GameStatus;
import racingcar.car.Constant;
import racingcar.car.error.Error;

public class ValidateCarNameInputSplitResultSizeMoreThanZero implements Validator {
    private final String ERROR_MESSAGE = Error.createErrorComment("최소 한개 이상의 차 이름이 있어야 합니다.");

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
            System.out.println(ERROR_MESSAGE);
        }
        return validateResult;
    }
}

