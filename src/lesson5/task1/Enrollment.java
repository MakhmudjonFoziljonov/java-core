package lesson5.task1;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Enrollment {
    private Student student;

    private int totalPoints = 0;
    private List<Attendance> attendanceList = new ArrayList<>();

    public Enrollment(Student student) {
        this.student = student;

    }

    public void markAttendance(LocalDateTime dateTime, boolean present) {
        attendanceList.add(
            new Attendance(dateTime, present)
        );
    }

    public void addPoints(int point) {
        totalPoints += point;
    }
}
