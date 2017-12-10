import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Repository rep  = new Repository();

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

        for (int i = 0; i < rep.getSize(); i++) {
            System.out.println(rep.getPerson(i).toString());
        }
        System.out.println();


        rep.remove(3);

        System.out.println(rep.searchById(5).toString());

        System.out.println();

        Person[] foundPersons = rep.searchByName("John");
        for (int i = 0; i <foundPersons.length; i++) {
            System.out.println(foundPersons[i].toString());
        }

        System.out.println();

        Person[] foundPersonsAge = rep.searchByAge(22);
        for (int i = 0; i <foundPersonsAge.length; i++) {
            System.out.println(foundPersonsAge[i].toString());
        }

    }

}
