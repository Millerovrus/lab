import java.util.ArrayList;
import java.util.Comparator;

public class Repository {
    private int size = 0;
    private Person[] persons;

    public void add(Person person) {
        if (size == 0) {
            persons = new Person[1];
            size++;
            persons[0] = person;
        } else {
            Person[] tempPersons = new Person[size + 1];
            for (int i = 0; i < persons.length; i++)
                tempPersons[i] = persons[i];
            tempPersons[size] = person;
            size++;
            this.persons = tempPersons;
        }
    }

    public void remove(int id) {
        if (checkId(id) != -1) {
            Person[] tempPersons = new Person[size - 1];
            System.arraycopy(persons, 0, tempPersons, 0, checkId(id));
            System.arraycopy(persons, checkId(id) + 1, tempPersons, checkId(id), size - (checkId(id) + 1));
            this.persons = tempPersons;
            size--;
        } else {
            System.out.println("Person not found");
        }
    }

    public Person searchById(int id){
        for(int i = 0; i < size; i++){
            if(persons[i].getId() == id) {
                return persons[i];
            }
        }
        return null;
    }

    public Person[] searchByName(String name){
        ArrayList<Person> listFoundPersons = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if (persons[i].getName().equals(name)) {
                listFoundPersons.add(persons[i]);
            }
        }
        Person foundPersons[] = new Person[listFoundPersons.size()];
        listFoundPersons.toArray(foundPersons);
        return foundPersons;
    }

    public Person[] searchByAge(int age){
        ArrayList<Person> listFoundPersons = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if (persons[i].getAge() == age) {
                listFoundPersons.add(persons[i]);
            }
        }
        Person foundPersons[] = new Person[listFoundPersons.size()];
        listFoundPersons.toArray(foundPersons);
        return foundPersons;
    }

    public int getSize() {
        return this.size;
    }

    public Person getPerson(int i) {
        return persons[i];
    }

    private int checkId(int id) {
        for (int i = 0; i < this.size; i++) {
            if (persons[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
