package blog.ordincode.domain;

import blog.ordincode.event.EventDispatcher;
import blog.ordincode.event.events.GameOverEvent;
import blog.ordincode.event.events.RoundOverEvent;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> players;

    public RacingGame(List<Car> players) {
        this.players = new ArrayList<>(players);
    }

    public void doRun(int round) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(round + "라운드 진행완료");
        EventDispatcher.raise(new RoundOverEvent(findFirst(), round));
    }

    public void over() {
        System.out.println("게임종료");
        EventDispatcher.raise(new GameOverEvent(findFirst()));
    }

    public Car findFirst() {
        return players
                .stream()
                .reduce((Car::findFirst))
                .orElseThrow(IllegalArgumentException::new);
    }
}
