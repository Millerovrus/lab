package Entity;

import Interfaces.Idable;

public class Car implements Idable<Integer> {
    private Integer id;
    private String model;
    private String color;
    private String number;
    private int yearOfIssue;

    public Car(Integer id, String model, String color, String number, int yearOfIssue) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.number = number;
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Entity.Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", number='" + number + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                '}';
    }
}
