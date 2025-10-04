package lesson5.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Attendance {
    private LocalDateTime date;
    private boolean present;
}
