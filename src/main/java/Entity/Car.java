package Entity;

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

    @Override
    public Integer getId() {
        return this.id;
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
                '}';
    }
}
