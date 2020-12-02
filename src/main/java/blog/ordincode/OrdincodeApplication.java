package blog.ordincode;

import blog.ordincode.domain.Car;
import blog.ordincode.domain.RacingGame;

import java.util.Arrays;
import java.util.List;

public class OrdincodeApplication {
    public static void main(String[] args) throws InterruptedException {
        Car car1 = Car.of("car1");
        Car car2 = Car.of("car2");
        Car car3 = Car.of("car3");
        List<Car> players = Arrays.asList(
                car1,
                car2,
                car3
        );

        RacingGame racingGame = new RacingGame(players);

        car1.move(1);
        racingGame.doRun(1);

        car2.move(2);
        racingGame.doRun(2);

        car3.move(3);
        racingGame.doRun(3);

        car1.move(4);
        racingGame.doRun(4);

        car2.move(5);
        racingGame.doRun(5);
        racingGame.over();
    }
}
