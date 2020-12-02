package blog.ordincode.domain;

import blog.ordincode.event.EventDispatcher;
import blog.ordincode.event.GameOverEvent;
import blog.ordincode.event.RoundOverEvent;
import blog.ordincode.event.handler.GameOverHandler;
import blog.ordincode.event.handler.RoundOverHandler;

import java.util.List;

public class RacingGame {
    private final List<Car> players;

    public RacingGame(List<Car> players) {
        this.players = players;
    }

    public void doRun(int round) {
        System.out.println(round + "진행");
        for (Car car : players) {
            if (Dice.isRun()) {
                car.move();
            }
        }

        EventDispatcher.handle(new RoundOverHandler());
        EventDispatcher.raise(new RoundOverEvent(players, round));
        EventDispatcher.reset();
    }

    public void over() {
        EventDispatcher.handle(new GameOverHandler());
        EventDispatcher.raise(new GameOverEvent(players));
        EventDispatcher.reset();
    }
}
