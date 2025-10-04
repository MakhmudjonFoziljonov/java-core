package lesson5.task2;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Team {
    private final String teamName;
    private int score = 0;

    public void incrementScore() {
        score++;
    }

    @Override
    public String toString() {
        return teamName + ": " + score;
    }
}
