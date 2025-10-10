package lesson6;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Passenger{
    private String fullName;

    @Override
    public String toString() {
        return "Passenger: " + fullName;
    }
}