package racingcar.car.model.domain;

import racingcar.car.Constant;

public class Car {
    private final int CAR_MOVE_CONDITION = 4;
    private int location;
    private String name;

    protected Car(int location, String name) {
        this.location = location;
        this.name = name;
    }

    public static Car createCar(String name) {
        return new Car(0, name);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int move(int input) {
        location += getIntFromBoolean(input >= CAR_MOVE_CONDITION);
        return location;
    }

    private int getIntFromBoolean(boolean flag) {/* 반환값 : 1(flag = true), 0(flag = false) */
        return 1 & Boolean.hashCode(flag) >> 1;
    }

    public String getNameEqualExactlyLocation(int maxLocation) {
        if (location == maxLocation)
            return name;
        return Constant.CAR_IS_NOTMATCHING;
    }
}
