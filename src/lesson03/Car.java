package lesson03;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private String country;
    private String model;
    private int yearOfManufacture;

    public void printCarInfo() {
        System.out.printf("Car: %s %s (%d)%n", country, model, yearOfManufacture);
    }

    @Override
    public String toString() {
        return "Car" +
            "{" +
            "country='" + country + '\'' +
            ", model='" + model + '\'' +
            ", yearOfManufacture=" + yearOfManufacture +
            '}';
    }
}


