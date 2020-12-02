package blog.ordincode.domain;

public class BroadCaster {
    public void broadcastWhileRacing(int round, Car firstCar) {
        System.out.println(
                String.format("%d 라운드: %s 이/가 선두입니다", round, firstCar.getName())
        );
    }

    public void broadcastGameResult(Car winner) {
        System.out.println(
                String.format("최종 우승자는 %s 입니다", winner.getName())
        );
    }
}
