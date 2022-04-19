package racingcar.car.model.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {
    private final List<Car> cars;

    protected Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String input) {
        String[] names = validateSplitResultSizeMoreThanZero(input);
        return new Cars(createCarsByInput(names));
    }

    private static List<Car> createCarsByInput(String[] names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.createCar(name));
        }
        return cars;
    }

    private static String[] validateSplitResultSizeMoreThanZero(String input) {
        String[] names = input.trim().split(",");
        if(names.length==0)
            throw new IllegalArgumentException("최소 한개 이상의 차 이름이 있어야합니다");
        return names;
    }

    public LinkedHashMap<String,Integer> move() {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Car car : cars) {
            result.put(car.getName(),car.move(pickNumberInRange(0,9)));
        }
        return result;
    }
}
