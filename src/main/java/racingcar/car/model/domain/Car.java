package racingcar.car.model.domain;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private final int CAR_MOVE_CONDITION = 4;
    private int location;
    private String name;


    protected Car(int location, String name) {
        this.location = location;
        this.name = name;
    }

    public static Car createCar(String name){
        checkCarNameLength(name);
        return new Car(0,name);
    }

    public String getName() {
        return name;
    }

    private static void checkCarNameLength(String name) {
        if(name.length()>NAME_MAX_LENGTH || name.length()<NAME_MIN_LENGTH)
            throw new IllegalArgumentException("차 이름은 5글자를 넘을수 없습니다");
    }

    public int move(int input) {
        location += getIntFromBoolean(input>=CAR_MOVE_CONDITION);
        return location;
    }

    private int getIntFromBoolean(boolean flag) {/* 반환값 : 1(flag = true), 0(flag = false) */
        return 1 & Boolean.hashCode(flag) >> 1;
    }
}
