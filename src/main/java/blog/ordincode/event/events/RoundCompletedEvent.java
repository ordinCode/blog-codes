package blog.ordincode.event.events;

import blog.ordincode.domain.Car;

public class RoundCompletedEvent {
    private final Car first;
    private final int round;

    public RoundCompletedEvent(Car player, int round) {
        this.first = player;
        this.round = round;
    }

    public Car getFirst() {
        return first;
    }

    public int getRound() {
        return round;
    }
}
