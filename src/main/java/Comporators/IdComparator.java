package Comporators;

import Entity.Person;

public class IdComparator implements InterfaceComparator <Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return (o1.getId() < o2.getId()) ? -1 : ((o1.getId().equals(o2.getId())) ? 0 : 1);
    }
}
