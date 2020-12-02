package blog.ordincode.event.handler;

import blog.ordincode.domain.Car;
import blog.ordincode.event.events.GameFinishedEvent;
import blog.ordincode.event.events.RoundCompletedEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundOverHandlerTest {
    @DisplayName("canHandle 테스트 - true인 경우")
    @Test
    void canHandleWhenTrue() {
        RoundOverHandler roundOverHandler = new RoundOverHandler();

        RoundCompletedEvent roundCompletedEvent = new RoundCompletedEvent(Car.of("car1"), 1);

        assertThat(roundOverHandler.canHandle(roundCompletedEvent)).isTrue();
    }

    @DisplayName("canHandle 테스트 - false인 경우")
    @Test
    void canHandleWhenFalse() {
        RoundOverHandler roundOverHandler = new RoundOverHandler();

        GameFinishedEvent gameFinishedEvent = new GameFinishedEvent(Car.of("car1"));

        assertAll(
                () -> assertThat(roundOverHandler.canHandle("a")).isFalse(),
                () -> assertThat(roundOverHandler.canHandle(gameFinishedEvent)).isFalse()
        );
    }
}
