package blog.ordincode.event.events;

import blog.ordincode.domain.Car;

public class RoundCompletedEvent {
    private final Car first;
    private final int round;

    public RoundCompletedEvent(Car firstCar, int round) {
        this.first = firstCar;
        this.round = round;
    }

    public Car getFirst() {
        return first;
    }

    public int getRound() {
        return round;
    }
}
