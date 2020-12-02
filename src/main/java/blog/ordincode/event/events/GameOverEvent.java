package blog.ordincode.event.events;

import blog.ordincode.domain.Car;

public class GameOverEvent {
    private final Car first;

    public GameOverEvent(Car players) {
        this.first = players;
    }

    public Car getFirst() {
        return first;
    }
}
