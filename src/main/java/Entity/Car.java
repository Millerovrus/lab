package Entity;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"model", "color", "number"}, name = "car")
public class Car implements Idable<Integer> {
    private Integer id;
    private String model;
    private String color;
    private String number;

    public Car(Integer id, String model, String color, String number) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.number = number;
    }

    public Car() {
    }

    @Override
    @XmlAttribute(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Entity.Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
