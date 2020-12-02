package blog.ordincode.event;

import blog.ordincode.domain.Car;

import java.util.List;

public class GameOverEvent {
    private final List<Car> players;

    public GameOverEvent(List<Car> players) {
        this.players = players;
    }

    public Car findWinner() {
        return players
                .stream()
                .reduce((Car::findFirst))
                .orElseThrow(IllegalArgumentException::new);
    }
}
