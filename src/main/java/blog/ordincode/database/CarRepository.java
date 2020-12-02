package blog.ordincode.database;

import blog.ordincode.domain.Car;

import java.util.HashMap;
import java.util.Map;

public class CarRepository {
    private final Map<Long, Car> carTable = new HashMap<>();
}
