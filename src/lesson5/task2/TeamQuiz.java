package lesson5.task2;


import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class TeamQuiz extends Quiz{

    @Override
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===Start of the quiz ===");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getText());

            List<String> opts = q.getOptions();
            for (int j = 0; j < opts.size(); j++) {
                System.out.println("  " + (j + 1) + ") " + opts.get(j));
            }
            for (int j = 0; j < opts.size(); j++) {
                System.out.println("  " + (j+1) + ") " + opts.get(j));
            }

            for (Team team : teams) {
                System.out.print("Team \"" + team + "\", Enter the answer number: ");
                int answer = scanner.nextInt();
                if (answer >= 1 && answer <= opts.size()) {
                    if (q.isCorrect(answer - 1)) {
                        team.incrementScore();
                    }
                } else {
                    System.out.println(" An incorrect answer option is considered incorrect.");
                }
            }
        }
    }

    @Override
    public void showResults() {
        teams.sort(
            Comparator
                .comparingInt(
                    Team::getScore
                )
                .reversed());

        System.out.println("\n=== Итоговые результаты ===");
        for (Team team : teams) {
            System.out.println(team);
        }
    }
}
