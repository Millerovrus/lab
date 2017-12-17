package Search;

import Entity.Car;

public class CarNumberChecker implements Checker<Car>{
    @Override
    public boolean check(Object o1, Car o2) {
        return o1.equals(o2.getNumber());
    }
}
