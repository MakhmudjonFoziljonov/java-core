package lesson03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String name;
    private int age;

    public void introduce() {
        System.out.printf("Hi, my name is %s and I am %d years old.%n", name, age);
    }

    @Override
    public String toString() {
        return "Person" +
            "{" +
            "name='" + name + "', " +
            "age=" + age +
            '}';
    }
}

