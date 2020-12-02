package blog.ordincode.event;

import blog.ordincode.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundOverEventTest {

    @DisplayName("현재 1등 자동차 찾는 메서드 테스트")
    @Test
    void findCurrentTop() {
        List<Car> cars = Arrays.asList(
                Car.of("car1", 3),
                Car.of("car2", 0),
                Car.of("car3", 3),
                Car.of("car4", 1)
        );
        RoundOverEvent roundOverEvent = new RoundOverEvent(cars, 1);

        assertThat(roundOverEvent.findCurrentTop().getName()).isEqualTo("car1");
    }
}
