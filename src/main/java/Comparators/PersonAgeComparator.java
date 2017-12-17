package Comparators;

import Entity.Person;

public class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getDateOfBirthday().compareTo(o2.getDateOfBirthday());
    }
}
