package lesson5.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Setting up a quiz ===");

        System.out.print("Enter the number of questions: ");
        int numQuestions = scanner.nextInt();
        scanner.nextLine();

        var quiz = new TeamQuiz();

        for (int i = 0; i < numQuestions; i++) {
            System.out.print("\nEnter your question text " + (i + 1) + ": ");
            String text = scanner.nextLine();

            System.out.print("Enter the number of answer options: ");
            int numOptions = scanner.nextInt();
            scanner.nextLine();

            List<String> options = new ArrayList<>();
            for (int j = 0; j < numOptions; j++) {
                System.out.print("  Option " + (j + 1) + ": ");
                String opt = scanner.nextLine();
                options.add(opt);
            }

            System.out.print("Enter the number of the correct option (1-" + numOptions + "): ");
            int correct = scanner.nextInt();
            scanner.nextLine();

            var question = new Question(text, options, correct - 1);
            quiz.addQuestion(question);

            System.out.println("Question added.");
        }

        System.out.print("\nEnter the number of teams: ");
        int numTeams = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numTeams; i++) {
            System.out.print("Enter the team name " + (i + 1) + ": ");
            String teamName = scanner.nextLine();
            quiz.addTeam(new Team(teamName));
        }
        quiz.startQuiz();
        quiz.showResults();

        scanner.close();
    }
}
