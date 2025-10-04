package lesson5.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Question {
    private String text;
    private List<String> options;
    private int correctIndex;

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctIndex;
    }
}
