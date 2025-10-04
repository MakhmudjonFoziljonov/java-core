package lesson5.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
abstract public class User {
    private String phone;
    private String fullName;
    private int birthDate;
}
