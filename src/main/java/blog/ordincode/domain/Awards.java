package blog.ordincode.domain;

public class Awards {
    private final static int PRIZE = 10000;

    public void givePrize(Car winner) {
        System.out.println(
                String.format("%s 에게 %d 원을 수여하였습니다.", winner.getName(), PRIZE)
        );
    }
}
