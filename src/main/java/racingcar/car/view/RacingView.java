package racingcar.car.view;

import racingcar.car.GameStatus;
import racingcar.car.GlobalParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingView {
    protected RacingView() {
    }

    public static RacingView createRacingView() {
        return new RacingView();
    }

    public String getInput(GameStatus gameStatus) {
        if (gameStatus == GameStatus.GET_CAR_NAME)
            return getCarNames();
        if (gameStatus == GameStatus.GET_RACING_NUMBER)
            return getRacingNumber();
        return null;
    }

    private String getCarNames() {
        System.out.println(GlobalParams.GUIDE_FOR_INPUT_CARNAME);
        return readLine();
    }

    private String getRacingNumber() {
        System.out.println(GlobalParams.GUIDE_FOR_INPUT_RACINGNUMBER);
        return readLine();
    }

    public void printProgress(HashMap<String, Integer> moveProgress) {
        for (Map.Entry<String, Integer> progressPerCar : moveProgress.entrySet()) {
            printProgressPerCar(progressPerCar.getKey(), progressPerCar.getValue());
        }
        System.out.println();
    }

    private void printProgressPerCar(String carName, int location) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < location; i++)
            stringBuilder.append(GlobalParams.PROGRESS_BAR);
        System.out.println(carName + GlobalParams.PROGRESS_SPLITER + stringBuilder.toString());
    }

    public void printWinner(ArrayList<String> winnerList) {
        System.out.println(GlobalParams.WINNER_GUIDE + String.join(GlobalParams.WINNER_SPLITER, winnerList));
    }

}
