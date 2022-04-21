package racingcar.car.controller;

import racingcar.car.GameStatus;
import racingcar.car.model.RacingModel;
import racingcar.car.view.RacingView;

public class RacingController {
    private final RacingView racingView;
    private final RacingModel racingModel;
    private final String GET_RACING_NUMBER_ERROR = "-1";
    private final String GET_CAR_NAME_ERROR = "";

    protected RacingController() {
        this.racingView = RacingView.createRacingView();
        this.racingModel = RacingModel.createModel();
    }

    public static RacingController createRacingController() {
        return new RacingController();
    }

    public String getRacingNumber() {
        String racingNumber = GET_RACING_NUMBER_ERROR;
        while (racingNumber.equals(GET_RACING_NUMBER_ERROR)) {
            try {
                racingNumber = racingModel.validateInput(racingView.getRacingNumber(), GameStatus.GET_RACING_NUMBER);
            } catch (IllegalArgumentException e) {
                racingNumber = GET_RACING_NUMBER_ERROR;
            }
        }
        return racingNumber;
    }

    public String getCarNames() {
        String carNames = GET_CAR_NAME_ERROR;
        while (carNames.equals(GET_CAR_NAME_ERROR)) {
            try {
                carNames = racingModel.validateInput(racingView.getCarNames(), GameStatus.GET_CAR_NAME);
            } catch (IllegalArgumentException e) {
                carNames = GET_CAR_NAME_ERROR;
            }

        }
        return carNames;
    }

}
