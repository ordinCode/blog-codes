package blog.ordincode.event.handler;

import blog.ordincode.domain.Car;
import blog.ordincode.event.events.GameFinishedEvent;
import blog.ordincode.event.events.RoundCompletedEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundCompletedHandlerTest {
    @DisplayName("canHandle 테스트 - true인 경우")
    @Test
    void canHandleWhenTrue() {
        RoundCompletedHandler roundCompletedHandler = new RoundCompletedHandler();

        RoundCompletedEvent roundCompletedEvent = new RoundCompletedEvent(Car.of("car1"), 1);

        assertThat(roundCompletedHandler.canHandle(roundCompletedEvent)).isTrue();
    }

    @DisplayName("canHandle 테스트 - false인 경우")
    @Test
    void canHandleWhenFalse() {
        RoundCompletedHandler roundCompletedHandler = new RoundCompletedHandler();

        GameFinishedEvent gameFinishedEvent = new GameFinishedEvent(Car.of("car1"));

        assertAll(
                () -> assertThat(roundCompletedHandler.canHandle("a")).isFalse(),
                () -> assertThat(roundCompletedHandler.canHandle(gameFinishedEvent)).isFalse()
        );
    }
}
