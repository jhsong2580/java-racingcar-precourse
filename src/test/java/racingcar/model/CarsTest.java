package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.car.model.domain.Car;
import racingcar.car.model.domain.Cars;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class CarsTest extends NsTest {
    private Cars cars;
    @BeforeEach
    public void initCarsTest(){
        cars = Cars.createCars("c1,c2,c3");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

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

    @Test
    public void Cars를통한CarMove호출(){
        assertRandomNumberInRangeTest(
                ()->{
                    LinkedHashMap<String, Integer> move = null;
                    for(int i=0;i<9;i++) {
                         move = cars.move();
                    }
                    assertThat(move).containsExactly(
                            entry("c1",5),
                            entry("c2",5),
                            entry("c3",6)
                    );

                },
            3,8,5,
                5,5,6,
                2,1,2,
                1,7,5,
                9,9,4,
                6,2,1,
                7,0,2,
                4,2,8,
                2,4,7
        );
    }
}
