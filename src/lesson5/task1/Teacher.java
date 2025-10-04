package lesson5.task1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher extends User {
    public Teacher(String phone, String fullName, int birthDate) {
        super(phone, fullName, birthDate);
    }
}
