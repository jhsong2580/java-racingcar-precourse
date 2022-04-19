package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.model.domain.Cars;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @ParameterizedTest
    @ValueSource(strings = {"t1,t2,t3,t4,t5","t,t,t,t,t","ttttt,tttt,tttt,tttt,tttt"})
    public void 문자열로부터_차생성하기_정상동작 (String input){
        Cars cars = Cars.createCars(input);
        assertThat(cars).isInstanceOf(Cars.class);
    }
    @ParameterizedTest
    @ValueSource(strings = {"t1,t2,,t4,t5","","tttttt,tttt,tttt,tttt,tttt"})
    public void 문자열로부터_차생성하기_실패(String input){
        assertThatThrownBy(() -> Cars.createCars(input))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
