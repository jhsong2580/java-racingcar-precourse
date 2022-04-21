package racingcar.car.view;

import racingcar.car.GameStatus;

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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    private String getRacingNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
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
            stringBuilder.append("-");
        System.out.println(carName + " : " + stringBuilder.toString());
    }


}
