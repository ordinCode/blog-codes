package blog.ordincode.event.handler;

import blog.ordincode.domain.BroadCaster;
import blog.ordincode.event.events.RoundCompletedEvent;

public class RoundOverHandler implements EventHandler<RoundCompletedEvent> {
    private final BroadCaster broadCaster = new BroadCaster();

    @Override
    public void handle(RoundCompletedEvent event) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        broadCaster.broadcastWhileRacing(event.getRound(), event.getFirst());
    }
}
