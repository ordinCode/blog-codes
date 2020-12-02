package blog.ordincode.event.handler;

import blog.ordincode.event.events.GameOverEvent;

public class GameOverHandler implements EventHandler<GameOverEvent> {

    @Override
    public void handle(GameOverEvent event) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                String.format("최종 우승자는 %s 입니다", event.getFirst().getName())
        );
    }
}
