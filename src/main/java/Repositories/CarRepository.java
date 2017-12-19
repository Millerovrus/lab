package Repositories;

import Comparators.*;
import Entity.Car;
import Search.CarColorChecker;
import Search.CarIdChecker;
import Search.CarModelChecker;

import java.util.List;

public class CarRepository extends RepositoryAbstract<Car, Integer>{

    List<Car> searchByColor(String color) {
        return searchBy(new CarColorChecker(), color);
    }
    List<Car> searchByModel(String name){
        return searchBy(new CarModelChecker(), name);
    }
    List<Car> searchById(int id){
        return searchBy(new CarIdChecker(), id);
    }
    List<Car> searchByNumber(String number){
        return searchBy(new CarIdChecker(), number);
    }
    void sortByColor(){
        sort(getRepository(), new CarColorComparator());
    }
    void sortById(){
        sort(getRepository(), new CarIdComparator());
    }
    void sortByModel(){
        sort(getRepository(), new CarModelComparator());
    }
    void sortByNumber(){
        sort(getRepository(), new CarNumberComparator());
    }
}
