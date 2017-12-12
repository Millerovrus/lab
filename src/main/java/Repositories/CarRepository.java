package Repositories;

import Entity.Car;
import java.util.LinkedList;
import java.util.List;

public class CarRepository extends RepositoryAbstract<Car, Integer>{

    public List<Car> searchByModel(String model){
        List <Car> foundObjects = new LinkedList<>();
        for (Car object : objects) {
            if (object.getModel().equals(model)) {
                foundObjects.add(object);
            }
        }
        return foundObjects;
    }

    public List <Car> searchByYear(int year){
        List <Car> foundObjects = new LinkedList<>();
        for (Car object : objects) {
            if (object.getYearOfIssue() == year) {
                foundObjects.add(object);
            }
        }
        return foundObjects;
    }

    public List <Car> searchByColor(String color){
        List <Car> foundObjects = new LinkedList<>();
        for (Car object : objects) {
            if (object.getColor().equals(color)) {
                foundObjects.add(object);
            }
        }
        return foundObjects;
    }


}
