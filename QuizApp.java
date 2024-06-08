import java.util.Scanner;

public class QuizApp 
{
    private static final int QUESTION_COUNT = 5;
    private static final int TIME_LIMIT_PER_QUESTION_SECONDS = 10;

    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;

    public static void main(String[] args) {
        String[][] questions = {
                {"What does JVM stand for?", "A) Java Variable Machine", "B) Java Virtual Machine", "C) Java Very Mighty", "D) Just VirtualMemory", "B"},
                {"What keyword is used to prevent a class from being subclassed?", "A) static", "B) final", "C) abstract", "D) private+", "B"},
                {"What keyword is used to allocate memory to objects in Java?", "A) new", "B) alloc", "C) create", "D) allocate", "A"},
                {"Which of the following is not a Java keyword?", "A) static", "B) final", "C) construct", "D) abstract", "C"},
                {"What is the access level of a class if no access modifier is specified?", "A) public", "B) private", "C) protected", "D) default", "D"}
        };

        for (int i = 0; i < QUESTION_COUNT; i++) {
            displayQuestion(questions[i]);
            String userAnswer = getUserAnswer();
            if (userAnswer.equalsIgnoreCase(questions[i][5])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + QUESTION_COUNT);
    }

    private static void displayQuestion(String[] question) {
        System.out.println(question[0]);
        for (int i = 1; i < 5; i++) {
            System.out.println(question[i]);
        }
        System.out.print("Your answer: ");
    }

    private static String getUserAnswer() {
        String answer = "";
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < TIME_LIMIT_PER_QUESTION_SECONDS * 1000) {
            if (scanner.hasNextLine()) {
                answer = scanner.nextLine().trim().toUpperCase();
                if (answer.matches("[ABCD]")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                }
            }
        }
        if (answer.isEmpty()) {
            System.out.println("Time's up!");
        }
        return answer;
    }
}
