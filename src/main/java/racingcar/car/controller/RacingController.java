package racingcar.car.controller;

import racingcar.car.GameStatus;
import racingcar.car.model.RacingModel;
import racingcar.car.view.RacingView;

public class RacingController {
    private final RacingView racingView;
    private final RacingModel racingModel;
    private final String ERROR_INPUT = "";

    protected RacingController() {
        this.racingView = RacingView.createRacingView();
        this.racingModel = RacingModel.createModel();
    }

    public static RacingController createRacingController() {
        return new RacingController();
    }

    private String getInput(GameStatus gameStatus) {
        String input = ERROR_INPUT;
        while (input.equals(ERROR_INPUT)) {
            try {
                input = racingModel.validateInput(racingView.getInput(gameStatus), gameStatus);
            } catch (IllegalArgumentException e) {
                input = ERROR_INPUT;
            }
        }
        return input;
    }
}
