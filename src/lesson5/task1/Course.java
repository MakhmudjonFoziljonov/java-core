package lesson5.task1;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Course {
    private String id;
    private String name;
    private String schedule;
    private int durationHours;

    private Teacher teacher;
    private List<Enrollment> enrollments = new ArrayList<>();

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        enrollments.add(
            new Enrollment(student)
        );
    }

    public void markAttendance(
        Student student,
        LocalDateTime dateTime,
        boolean present
    ) {
        enrollments
            .stream()
            .filter(enrollment -> enrollment.getStudent().equals(student))
            .findFirst()
            .ifPresent(enrollment -> enrollment.markAttendance(dateTime, present));

    }

    public void addPoints(
        Student student,
        int points
    ) {
        enrollments
            .stream()
            .filter(e -> e.getStudent().equals(student))
            .findFirst()
            .ifPresentOrElse(e -> e.addPoints(points), null);
    }

    public void printStudentReport() {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Enrollment enrollment : enrollments) {
            System.out.println("Student: " + enrollment.getStudent().getFullName());
            System.out.println("Total points: " + enrollment.getTotalPoints());
            System.out.println("Attendance: ");

            for (Attendance attendance : enrollment.getAttendanceList()) {
                System.out.println(
                    attendance.isPresent()
                        ? (attendance.getDate().format(formatter) + " Present")
                        : (attendance.getDate().format(formatter) + " Absent")
                );

            }
        }
    }
}
