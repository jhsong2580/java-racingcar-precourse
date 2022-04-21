package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.GameStatus;
import racingcar.car.model.RacingModel;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingModelTest {
    RacingModel racingModel;

    @BeforeEach
    public void init() {
        racingModel = RacingModel.createModel();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "0", "-1", "0.1"})
    public void racingNumber검증(String inputs) {
        assertThatThrownBy(() -> racingModel.validateInput(inputs, GameStatus.GET_RACING_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
