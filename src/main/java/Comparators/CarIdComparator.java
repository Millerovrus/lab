package Comparators;

import Entity.Car;

public class CarIdComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
