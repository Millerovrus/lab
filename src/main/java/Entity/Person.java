package Entity;

import JAXBParser.LocalDateAdapter;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = {"name", "dateOfBirthday"}, name = "person")
public class Person implements Idable<Integer> {
    private Integer id;
    private String name;
    private LocalDate dateOfBirthday;

    public Person(int id, String name, LocalDate dateOfBirthday) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
    }

    public Person() {
    }

    @Override
    @XmlAttribute(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
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