package blog.ordincode.domain;

import blog.ordincode.event.EventDispatcher;
import blog.ordincode.event.events.GameFinishedEvent;
import blog.ordincode.event.events.RoundCompletedEvent;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> players;

    public RacingGame(List<Car> players) {
        this.players = new ArrayList<>(players);
    }

    public void completeRound(int round) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(round + "라운드 진행완료");
        EventDispatcher.raise(new RoundCompletedEvent(findFirst(), round));
    }

    public void finish() {
        System.out.println("게임종료");
        EventDispatcher.raise(new GameFinishedEvent(findFirst()));
    }

    public Car findFirst() {
        return players
                .stream()
                .reduce((Car::findFirst))
                .orElseThrow(IllegalArgumentException::new);
    }
}
