package blog.ordincode.event.handler;

import blog.ordincode.domain.Car;
import blog.ordincode.event.events.GameOverEvent;
import blog.ordincode.event.events.RoundOverEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundOverHandlerTest {
    @DisplayName("canHandle 테스트 - true인 경우")
    @Test
    void canHandleWhenTrue() {
        RoundOverHandler roundOverHandler = new RoundOverHandler();

        RoundOverEvent roundOverEvent = new RoundOverEvent(Car.of("car1"), 1);

        assertThat(roundOverHandler.canHandle(roundOverEvent)).isTrue();
    }

    @DisplayName("canHandle 테스트 - false인 경우")
    @Test
    void canHandleWhenFalse() {
        RoundOverHandler roundOverHandler = new RoundOverHandler();

        GameOverEvent gameOverEvent = new GameOverEvent(Car.of("car1"));

        assertAll(
                () -> assertThat(roundOverHandler.canHandle("a")).isFalse(),
                () -> assertThat(roundOverHandler.canHandle(gameOverEvent)).isFalse()
        );
    }
}
