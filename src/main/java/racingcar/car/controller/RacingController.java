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

    public void startRace() {
        racingModel.createCars(getInput(GameStatus.GET_CAR_NAME)); /* 차 이름 입력후 검증, racingModel에 Cars 설정 */
        int racingNumber = Integer.parseInt(getInput(GameStatus.GET_RACING_NUMBER)); /* Racing 횟수 입력 후 검증, Int로 Cast */
        for (int racingCount = 0; racingCount < racingNumber; racingCount++) {
            racingView.printProgress(racingModel.move());
        }
        racingView.printWinner(racingModel.electWinner());
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
