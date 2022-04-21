package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.car.model.domain.Cars;

import java.util.Arrays;
import java.util.LinkedHashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CarsTest extends NsTest {
    private Cars cars;
    @BeforeEach
    public void initCarsTest(){
        cars = Cars.createCars("c1,c2,c3");

        assertRandomNumberInRangeTest(
                ()->{
                    for(int i=0;i<9;i++) {
                        cars.move();
                    }
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

    @Test
    public void Cars를통한CarMove호출(){

        assertRandomNumberInRangeTest(
                () -> {
                    LinkedHashMap<String, Integer> move = move = cars.move();
                    assertThat(move).containsExactly(
                            entry("c1", 6),
                            entry("c2", 6),
                            entry("c3", 7)
                    );
                },
                8, 9, 4
        );
    }
    @Test
    public void Car우승자_단일추출 (){
        assertThat(cars.electWinner())
                .isEqualTo(Arrays.asList("c3"));
    }

    @Test
    public void Car우승자_다수추출 (){
        assertRandomNumberInRangeTest(
                ()->{
                    cars.move();
                },
                3,4,3
        );
        assertThat(cars.electWinner())
                .isEqualTo(Arrays.asList("c2", "c3"));

        assertRandomNumberInRangeTest(
                ()->{
                    cars.move();
                },
                4,3,3
        );
        assertThat(cars.electWinner())
                .isEqualTo(Arrays.asList("c1","c2", "c3"));

    }
}
