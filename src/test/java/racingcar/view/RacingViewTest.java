package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.view.RacingView;

import java.io.*;

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
        String carNames = racingView.getCarNames();

        //then
        assertThat(carNames)
                .isEqualTo(iSay);
        assertThat(out.toString().trim())
                .isEqualTo((serverSay).trim());
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
