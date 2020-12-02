package blog.ordincode.event.handler;

import blog.ordincode.event.events.RoundOverEvent;

public class RoundOverHandler implements EventHandler<RoundOverEvent> {
    @Override
    public void handle(RoundOverEvent event) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                String.format("%d라운드: %s 이/가 선두입니다", event.getRound(), event.getFirst().getName())
        );
    }
}
