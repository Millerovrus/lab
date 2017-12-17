package Comparators;

import Entity.Car;

public class CarNumberComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getNumber().compareTo(o2.getNumber());
    }
}
