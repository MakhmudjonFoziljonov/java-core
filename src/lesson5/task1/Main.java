package lesson5.task1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Create - student, course  etc ...
        var student = new Student(
            "+998 93 595-47-17",
            "Foziljonov Mahmudjon",
            2003
        );

        var teacher = new Teacher(
            "+998 90 003-02-01",
            "David Laid",
            2000
        );

        var enrollment = new Enrollment(student);
        enrollment.markAttendance(LocalDateTime.now(), true);
        enrollment.addPoints(10);

        var course = new Course();
        course.setId(String.valueOf(UUID.randomUUID()));
        course.setName("Math");
        course.setSchedule("Monday, Wednesday, Friday");
        course.setDurationHours(2);
        course.setEnrollments(List.of(enrollment));
        course.assignTeacher(teacher);
        course.addPoints(student, 10);

        course.printStudentReport();
    }
}
