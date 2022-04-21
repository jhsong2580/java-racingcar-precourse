package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.GameStatus;
import racingcar.car.view.RacingView;

import java.io.*;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingViewTest {
    RacingView racingView;

    @BeforeEach
    public void init() {
        racingView = RacingView.createRacingView();
    }


    @Test
    public void 자동차이름받기() {
        //given
        String serverSay = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        String iSay = "t1,t2,t3";
        InputStream in = generateInputStream(iSay);
        OutputStream out = generateOutputStream();

        //when
        String carNames = racingView.getInput(GameStatus.GET_CAR_NAME);

        //then
        assertThat(carNames)
                .isEqualTo(iSay);
        assertThat(out.toString().trim())
                .isEqualTo((serverSay).trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "a", "-1", " "})
    public void 시도횟수입력받기(String input) {
        //given
        String serverSay = "시도할 횟수는 몇회인가요?";
        String iSay = input;
        InputStream in = generateInputStream(iSay);
        OutputStream out = generateOutputStream();
        //when
        String racingNumber = racingView.getInput(GameStatus.GET_RACING_NUMBER);
        //then
        assertThat(racingNumber)
                .isEqualTo(iSay);
        assertThat(out.toString().trim())
                .isEqualTo(serverSay);
    }

    @Test
    public void 차수별_실행결과_출력() {
        //given
        HashMap<String, Integer> moveProgress = new HashMap<>();
        moveProgress.put("c1", 5);
        moveProgress.put("c2", 2);
        OutputStream out = generateOutputStream();
        //when
        racingView.printProgress(moveProgress);
        //then
        assertThat(out.toString().trim())
                .isEqualTo("c1 : -----\r\n" + "c2 : --\r\n".trim());
    }

    private OutputStream generateOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }


    private InputStream generateInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        return in;
    }

}
