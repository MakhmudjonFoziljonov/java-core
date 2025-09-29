package lesson03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rectangle {
    private double length;
    private double width;

    public double calculateSquare() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return String.format("Rectangle" +
            "{" +
            "length=%.2f, width=%.2f" +
            "}", length, width);
    }
}
