package racingcar.car.model;

import racingcar.car.GameStatus;
import racingcar.car.model.domain.Cars;
import racingcar.car.model.validator.*;
import racingcar.car.view.RacingView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RacingModel {
    private final List<Validator> validators = new ArrayList<>();
    private final RacingView racingView;
    private Cars cars;
    protected RacingModel() {
        getValidators();
        racingView = RacingView.createRacingView();
    }

    private void getValidators() {
        validators.add(new ValidateRacingNumberIntputCannotParseInteger());
        validators.add(new ValidateRacingNumberInputRangeOverOne());
        validators.add(new ValidateCarNameInputSplitResultSizeMoreThanZero());
        validators.add(new ValidateCarNameInputCheckCarNameLength());
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

    public void createCars(String input) {
        cars = Cars.createCars(input);
    }

    public LinkedHashMap<String, Integer> move(){
        return cars.move();
    }

    public ArrayList<String> electWinner(){
         return cars.electWinner();
    }
}
