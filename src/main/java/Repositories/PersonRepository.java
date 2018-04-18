package Repositories;

import Comparators.PersonAgeComparator;
import Comparators.PersonIdComparator;
import Comparators.PersonNameComparator;
import Entity.Person;
import Search.PersonAgeChecker;
import Search.PersonIdChecker;
import Search.PersonNameChecker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlRootElement(name = "PersonRepository")
@XmlSeeAlso({Person.class})
public class PersonRepository extends RepositoryAbstract<Person, Integer> {

    List<Person> searchByAge(int age) {
        return searchBy(new PersonAgeChecker(), age);
    }
    List<Person> searchByName(String name){
        return searchBy(new PersonNameChecker(), name);
    }
    List<Person> searchById(int id){
        return searchBy(new PersonIdChecker(), id);
    }
    void sortByAge(){
        sort(getRepository(), new PersonAgeComparator());
    }
    void sortById(){
        sort(getRepository(), new PersonIdComparator());
    }
    void sortByName(){
        sort(getRepository(), new PersonNameComparator());
    }
}
