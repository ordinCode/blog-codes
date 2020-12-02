package blog.ordincode.domain;

import java.util.Random;

public class Dice {
    private final static Random random = new Random();

    public static boolean isRun() {
        return random.nextInt(9) > 5;
    }
}
