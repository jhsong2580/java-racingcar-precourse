package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.model.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car t1;
    Car t2;
    Car t3;
    @BeforeEach
    public void init(){
        t1 = Car.createCar("t1");
        t2 = Car.createCar("t2");
        t3 = Car.createCar("t3");
    }
    @Test
    public void Car생성하기_이름은5글자이하 (){
        assertThat(Car.createCar("POLIV")).isInstanceOf(Car.class);
        assertThat(Car.createCar("pol")).isInstanceOf(Car.class);
        assertThatThrownBy(() -> Car.createCar("testError"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Car.createCar(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
