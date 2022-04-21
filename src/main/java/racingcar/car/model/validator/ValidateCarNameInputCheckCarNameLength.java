package racingcar.car.model.validator;

import racingcar.car.GameStatus;

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
        String[] names = input.split(",");
        for (int i = 0; i < names.length && validateResult; i++) {
            if (names[i].length() > NAME_MAX_LENGTH || names[i].length() < NAME_MIN_LENGTH) {
                validateResult = false;
                System.out.println(ERROR_MESSAGE);
            }
        }
        return validateResult;
    }


}

