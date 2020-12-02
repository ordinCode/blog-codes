package blog.ordincode.domain;

public class Car {
    private String name;
    private Integer position;

    private Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(name, 0);
    }

    public void move(int count) {
        for (int i = 0; i < count; i++) {
            this.position++;
        }
    }

    public Car findFirst(Car car) {
        if (this.position >= car.position) {
            return this;
        }
        return car;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
