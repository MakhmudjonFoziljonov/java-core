package lesson5.task2;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
abstract public class Quiz {
    protected List<Question> questions;
    protected List<Team> teams;

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void addTeam(Team t) {
        teams.add(t);
    }

    public abstract void startQuiz();
    public abstract void showResults();
}
