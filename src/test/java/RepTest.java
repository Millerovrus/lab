import Comparators.PersonAgeComparator;
import Comparators.PersonIdComparator;
import Comparators.PersonNameComparator;
import Entity.Person;
import JAXBParser.JaxbParser;
import Repositories.PersonRepository;
import Repositories.RepositoryAbstract;
import Search.PersonAgeChecker;
import Search.PersonNameChecker;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class RepTest {
    @Test
    public void addPerson() throws Exception {
        PersonRepository rep  = new PersonRepository();
        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        rep.add(pers_1);
        Assert.assertEquals("Test addPerson Wrong!", rep.get(0),pers_1);
    }
    @Test
    public void removePerson() throws Exception {
        PersonRepository rep  = new PersonRepository();
        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        Person pers_2 = new Person(2,"Joe",new LocalDate(1995,5,10));
        rep.add(pers_1);
        rep.add(pers_2);
        rep.remove(1);
        Assert.assertEquals("Test removePerson Wrong!", rep.get(0),pers_2);
    }

    @Test
    public void sortById() throws Exception {
        PersonRepository rep  = new PersonRepository();
        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        Person pers_2 = new Person(2,"Joe",new LocalDate(1995,5,10));
        Person pers_3 = new Person(3,"Robert",new LocalDate(1980,3,15));
        Person pers_4 = new Person(4,"Nancy",new LocalDate(1977,4,14));

        rep.add(pers_3);
        rep.add(pers_1);
        rep.add(pers_2);
        rep.add(pers_4);

        PersonRepository sortedRep  = new PersonRepository();
        sortedRep.add(pers_1);
        sortedRep.add(pers_2);
        sortedRep.add(pers_3);
        sortedRep.add(pers_4);

        rep.sort(rep.getRepository(), new PersonIdComparator());
        for (int i = 0; i < rep.getSize(); i++) {
            Assert.assertEquals("Test sortByIDPerson Wrong!", rep.get(i), sortedRep.get(i));
        }
    }
    @Test
    public void sortByName() throws Exception {
        PersonRepository rep  = new PersonRepository();

        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        Person pers_2 = new Person(2,"Joe",new LocalDate(1995,5,10));
        Person pers_3 = new Person(3,"Robert",new LocalDate(1980,3,15));
        Person pers_4 = new Person(4,"Nancy",new LocalDate(1977,4,14));

        rep.add(pers_3);
        rep.add(pers_1);
        rep.add(pers_2);
        rep.add(pers_4);

        PersonRepository sortedRep  = new PersonRepository();
        sortedRep.add(pers_2);
        sortedRep.add(pers_4);
        sortedRep.add(pers_3);
        sortedRep.add(pers_1);

        rep.sort(rep.getRepository(), new PersonNameComparator());
        for (int i = 0; i < rep.getSize(); i++) {
            Assert.assertEquals("Test sortByNamePerson Wrong!", rep.get(i), sortedRep.get(i));
        }
    }

    @Test
    public void sortByAge() throws Exception {
        PersonRepository rep  = new PersonRepository();

        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        Person pers_2 = new Person(2,"Joe",new LocalDate(1995,5,10));
        Person pers_3 = new Person(3,"Robert",new LocalDate(1980,3,15));
        Person pers_4 = new Person(4,"Nancy",new LocalDate(1977,4,14));

        rep.add(pers_3);
        rep.add(pers_1);
        rep.add(pers_2);
        rep.add(pers_4);

        PersonRepository sortedRep  = new PersonRepository();
        sortedRep.add(pers_1);
        sortedRep.add(pers_4);
        sortedRep.add(pers_3);
        sortedRep.add(pers_2);

        rep.sort(rep.getRepository(), new PersonAgeComparator());
        for (int i = 0; i < rep.getSize(); i++) {
            Assert.assertEquals("Test sortByAgePerson Wrong!", rep.get(i), sortedRep.get(i));
        }
    }

    @Test
    public void searchByAge() throws Exception {
        PersonRepository rep  = new PersonRepository();

        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        Person pers_2 = new Person(2,"Joe",new LocalDate(1995,5,10));
        Person pers_3 = new Person(3,"Robert",new LocalDate(1980,3,15));
        Person pers_4 = new Person(4,"Nancy",new LocalDate(1977,4,14));
        Person pers_5 = new Person(5,"John",new LocalDate(1992,1,13));
        Person pers_6 = new Person(6,"Joe",new LocalDate(1999,2,21));
        Person pers_7 = new Person(7,"Joe",new LocalDate(1960,6,1));
        Person pers_8 = new Person(8,"Luis",new LocalDate(1995,11,11));

        rep.add(pers_5);
        rep.add(pers_6);
        rep.add(pers_1);
        rep.add(pers_3);
        rep.add(pers_4);
        rep.add(pers_2);
        rep.add(pers_7);
        rep.add(pers_8);

        PersonRepository searchRep  = new PersonRepository();
        searchRep.add(pers_2);
        searchRep.add(pers_8);
        for (int i = 0; i < searchRep.getSize(); i++) {
            Assert.assertEquals("Test searchByAgePerson Wrong!", rep.searchBy(new PersonAgeChecker(), 22).get(i), searchRep.get(i));
        }
    }

    @Test
    public void searchByName() throws Exception {
        PersonRepository rep  = new PersonRepository();

        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        Person pers_2 = new Person(2,"Joe",new LocalDate(1995,5,10));
        Person pers_3 = new Person(3,"Robert",new LocalDate(1980,3,15));
        Person pers_4 = new Person(4,"Nancy",new LocalDate(1977,4,14));
        Person pers_5 = new Person(5,"John",new LocalDate(1992,1,13));
        Person pers_6 = new Person(6,"Joe",new LocalDate(1999,2,21));
        Person pers_7 = new Person(7,"Joe",new LocalDate(1960,6,1));
        Person pers_8 = new Person(8,"Luis",new LocalDate(1995,11,11));

        rep.add(pers_1);
        rep.add(pers_2);
        rep.add(pers_3);
        rep.add(pers_4);
        rep.add(pers_5);
        rep.add(pers_6);
        rep.add(pers_7);
        rep.add(pers_8);

        PersonRepository searchRep  = new PersonRepository();
        searchRep.add(pers_2);
        searchRep.add(pers_6);
        searchRep.add(pers_7);
        for (int i = 0; i < searchRep.getSize(); i++) {
            Assert.assertEquals("Test searchByNamePerson Wrong!", rep.searchBy(new PersonNameChecker(), "Joe").get(i), searchRep.get(i));
        }
    }

    @Test
    public void searchById() throws Exception {
        PersonRepository rep  = new PersonRepository();

        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        Person pers_2 = new Person(2,"Joe",new LocalDate(1995,5,10));

        rep.add(pers_1);
        rep.add(pers_2);

        Assert.assertEquals("Test searchByIDPerson Wrong!", rep.searchById(2), pers_2);

    }

    @Test
    public void toXML(){
        RepositoryAbstract<Person, Integer> personRepository  = new PersonRepository();

        Person pers_1 = new Person(1,"Taylor",new LocalDate(1962,6,5));
        Person pers_2 = new Person(2,"Joe",new LocalDate(1995,5,10));
        Person pers_3 = new Person(3,"Robert",new LocalDate(1980,3,15));
        Person pers_4 = new Person(4,"Nancy",new LocalDate(1977,4,14));
        Person pers_5 = new Person(5,"John",new LocalDate(1992,1,13));
        Person pers_6 = new Person(6,"Joe",new LocalDate(1999,2,21));
        Person pers_7 = new Person(7,"Joe",new LocalDate(1960,6,1));
        Person pers_8 = new Person(8,"Luis",new LocalDate(1995,11,11));

        personRepository.add(pers_1);
        personRepository.add(pers_2);
        personRepository.add(pers_3);
        personRepository.add(pers_4);
        personRepository.add(pers_5);
        personRepository.add(pers_6);
        personRepository.add(pers_7);
        personRepository.add(pers_8);

        JaxbParser.convertObjectToXml(personRepository, "kek.xml");
    }

    @Test
    public void fromXML(){
        RepositoryAbstract rep = JaxbParser.convertXmlToObject("kek.xml");
        for (Object o : rep.getRepository()) {
            System.out.println(o.toString());
        }
    }
}
