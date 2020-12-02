package blog.ordincode.event.handler;

import blog.ordincode.domain.Awards;
import blog.ordincode.domain.BroadCaster;
import blog.ordincode.event.events.GameFinishedEvent;

public class GameFinishedHandler implements EventHandler<GameFinishedEvent> {
    private final BroadCaster broadCaster = new BroadCaster();
    private final Awards awards = new Awards();

    @Override
    public void handle(GameFinishedEvent event) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        broadCaster.broadcastGameResult(event.getFirst());
        awards.givePrize(event.getFirst());
    }
}
