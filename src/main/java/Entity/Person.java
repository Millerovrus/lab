package Entity;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Person implements Idable<Integer> {
    private Integer id;
    private String name;
    private LocalDate dateOfBirthday;

    public Person(int id, String name, LocalDate dateOfBirthday) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public Integer getAge(){
        Years tempAge = Years.yearsBetween(LocalDate.now(), dateOfBirthday);
        return Integer.parseInt(tempAge.toString().replaceAll("\\D",""));
    }

    @Override
    public String toString() {
        return "Entity.Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", age=" + getAge() +
                '}';
    }

}