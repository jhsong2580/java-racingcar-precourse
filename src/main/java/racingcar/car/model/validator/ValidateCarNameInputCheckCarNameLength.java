package racingcar.car.model.validator;

import racingcar.car.GameStatus;
import racingcar.car.GlobalParams;

public class ValidateCarNameInputCheckCarNameLength implements Validator {
    private final String ERROR_MESSAGE = "[ERROR] 차 이름은 1~5글자여야 합니다";
    private final int NAME_MAX_LENGTH = 5;
    private final int NAME_MIN_LENGTH = 1;

    @Override
    public boolean canValidate(GameStatus gameStatus) {
        return gameStatus == GameStatus.GET_CAR_NAME;
    }

    @Override
    public boolean validate(String input) {
        boolean validateResult = true;
        String[] names = input.split(GlobalParams.CAR_NAMES_SPLITER);
        for (int i = 0; i < names.length && validateResult; i++) {
            validateResult = validateResult && validateNameLength(names[i]);
        }
        return validateResult;
    }

    private boolean validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        return true;
    }


}

