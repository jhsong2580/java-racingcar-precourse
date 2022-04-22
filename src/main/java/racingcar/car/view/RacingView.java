package racingcar.car.view;

import racingcar.car.Constant;
import racingcar.car.GameStatus;
import racingcar.car.model.domain.Car;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingView {

    public String getInput(GameStatus gameStatus) {
        if (gameStatus == GameStatus.GET_CAR_NAME)
            return getCarNames();
        if (gameStatus == GameStatus.GET_RACING_NUMBER)
            return getRacingNumber();
        return null;
    }

    private String getCarNames() {
        System.out.println(Constant.GUIDE_FOR_INPUT_CARNAME);
        return readLine();
    }

    private String getRacingNumber() {
        System.out.println(Constant.GUIDE_FOR_INPUT_RACINGNUMBER);
        return readLine();
    }

    public void printProgress(ArrayList<Car> cars) {
        for (Car car : cars) {
            printProgressPerCar(car);
        }
        System.out.println();
    }

    private void printProgressPerCar(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.getLocation(); i++)
            stringBuilder.append(Constant.PROGRESS_BAR);
        System.out.println(car.getName() + Constant.PROGRESS_SPLITER + stringBuilder.toString());
    }

    public void printWinner(ArrayList<Car> cars) {
        ArrayList<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            winnerNames.add(car.getName());
        }
        System.out.println(Constant.WINNER_GUIDE + String.join(Constant.WINNER_SPLITER, winnerNames));
    }

}
