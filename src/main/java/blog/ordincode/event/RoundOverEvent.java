package blog.ordincode.event;

import blog.ordincode.domain.Car;

import java.util.List;

public class RoundOverEvent {
    private final List<Car> players;
    private final int round;

    public RoundOverEvent(List<Car> players, int round) {
        this.players = players;
        this.round = round;
    }

    public Car findCurrentTop() {
        return players
                .stream()
                .reduce((Car::findFirst))
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getRound() {
        return round;
    }
}
