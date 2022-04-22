package racingcar.car.model.domain;

import racingcar.car.Constant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {
    private final List<Car> cars;

    protected Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String input) {
        String[] names = input.split(Constant.CAR_NAMES_DELIMITER);
        return new Cars(createCarsByInput(names));
    }

    private static List<Car> createCarsByInput(String[] names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.createCar(name));
        }
        return cars;
    }

    public LinkedHashMap<String, Integer> move() {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), car.move(pickNumberInRange(Constant.RANGE_FOR_CAR_MOVING_MIN, Constant.RANGE_FOR_CAR_MOVING_MAX)));
        }
        return result;
    }

    public ArrayList<String> electWinner() {
        int maxLocation = getMaxLocation();
        return getWinnerList(maxLocation);
    }

    private ArrayList<String> getWinnerList(int scoreForWin) {
        ArrayList<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            String carName = car.getNameEqualExactlyLocation(scoreForWin);
            winnerList.add(carName);
        }
        winnerList.removeIf(s -> s.equals(GlobalParams.CAR_IS_NOTMATCHING));
        return winnerList;
    }

    private int getMaxLocation() {
        int maxLocation = -1;
        for (Car car : cars) {
            maxLocation = Math.max(maxLocation, car.getLocation());
        }
        return maxLocation;
    }
}
