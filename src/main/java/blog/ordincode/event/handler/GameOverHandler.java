package blog.ordincode.event.handler;

import blog.ordincode.event.GameOverEvent;

public class GameOverHandler implements EventHandler<GameOverEvent> {
    @Override
    public void handle(GameOverEvent event) {
        System.out.println("게임 종료, 최종우승자는");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(event.findWinner().getName());
    }
}
