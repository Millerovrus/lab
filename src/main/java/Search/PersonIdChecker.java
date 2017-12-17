package Search;

import Entity.Person;

public class PersonIdChecker implements Checker <Person> {
    @Override
    public boolean check(Object o1, Person o2) {
        return o1.equals(o2.getId());
    }
}
