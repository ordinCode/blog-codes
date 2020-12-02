package blog.ordincode;

import blog.ordincode.domain.Car;
import blog.ordincode.domain.RacingGame;

import java.util.Arrays;
import java.util.List;

public class OrdincodeApplication {
    public static void main(String[] args) {
        List<Car> players = Arrays.asList(
                Car.of("car1"),
                Car.of("car2"),
                Car.of("car3")
        );

        RacingGame racingGame = new RacingGame(players);

        racingGame.doRun(1);
        racingGame.doRun(2);
        racingGame.doRun(3);
        racingGame.doRun(4);
        racingGame.doRun(5);
        racingGame.over();
    }
}
