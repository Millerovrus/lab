import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Person implements Comparable<Person>{
    private int id;
    private String name;
    private LocalDate dateOfBirthday;

    public Person(int id, String name, LocalDate dateOfBirthday) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public int getAge(){
        Years tempAge = Years.yearsBetween(LocalDate.now(), dateOfBirthday);
        return Integer.parseInt(tempAge.toString().replaceAll("\\D",""));
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", age=" + getAge() +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.getName());
    }
}
