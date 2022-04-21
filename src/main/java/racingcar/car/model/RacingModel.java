package racingcar.car.model;

import racingcar.car.GameStatus;
import racingcar.car.model.validator.ValidateRacingNumberInputRangeOverOne;
import racingcar.car.model.validator.ValidateRacingNumberIntputCannotParseInteger;
import racingcar.car.model.validator.Validator;
import racingcar.car.view.RacingView;

import java.util.ArrayList;
import java.util.List;

public class RacingModel {
    private final List<Validator> validators = new ArrayList<>();
    private final RacingView racingView;

    protected RacingModel() {
        validators.add(new ValidateRacingNumberIntputCannotParseInteger());
        validators.add(new ValidateRacingNumberInputRangeOverOne());
        racingView = RacingView.createRacingView();
    }

    public static RacingModel createModel() {
        return new RacingModel();
    }

    public String validateInput(String input, GameStatus gameStatus) {
        boolean validateResult = true;
        for (int i = 0; i < validators.size() && validateResult; i++) {
            validateResult = validateResult && excuteValidate(validators.get(i), gameStatus, input);
        }
        if (validateResult == false)
            throw new IllegalArgumentException();
        return input;
    }

    private boolean excuteValidate(Validator validator, GameStatus gameStatus, String input) {
        if (validator.canValidate(gameStatus) == false)
            return true;
        return validator.validate(input);
    }
}
