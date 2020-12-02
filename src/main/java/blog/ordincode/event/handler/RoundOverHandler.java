package blog.ordincode.event.handler;

import blog.ordincode.event.RoundOverEvent;

public class RoundOverHandler implements EventHandler<RoundOverEvent> {
    @Override
    public void handle(RoundOverEvent event) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%d 라운드: %s 가 선두입니다.", event.getRound(), event.findCurrentTop().getName()));
    }
}
