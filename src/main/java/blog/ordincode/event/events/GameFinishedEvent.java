package blog.ordincode.event.events;

import blog.ordincode.domain.Car;

public class GameFinishedEvent {
    private final Car first;

    public GameFinishedEvent(Car players) {
        this.first = players;
    }

    public Car getFirst() {
        return first;
    }
}
