package lesson5.task1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends User{
    public Student(String phone, String fullName, int birthDate) {
        super(phone, fullName, birthDate);
    }
}
