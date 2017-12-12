package Repositories;

import java.util.LinkedList;
import java.util.List;
import Entity.Person;

public class PersonRepository extends RepositoryAbstract<Person, Integer> {

    public List <Person> searchByName(String name){
        List <Person> foundObjects = new LinkedList<>();
        for (Person object : objects) {
            if (object.getName().equals(name)) {
                foundObjects.add(object);
            }
        }
        return foundObjects;
    }

    public List <Person> searchByAge(int age){
        List <Person> foundObjects = new LinkedList<>();
        for (Person object : objects) {
            if (object.getAge() == age) {
                foundObjects.add(object);
            }
        }
        return foundObjects;
    }
}
