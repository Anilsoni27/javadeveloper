import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int number = r.nextInt(100) + 1;
        int guess;
        int chances = 7;

        System.out.println("Welcome to Number Guessing Game");
        System.out.println("Guess a number between 1 and 100.");

        while (chances > 0) {

            System.out.print("Enter your guess: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            guess = sc.nextInt();

            if (guess == number) {
                System.out.println("Correct! You guessed the number.");
                break;
            } else if (guess > number) {
                System.out.println("Too High");
            } else {
                System.out.println("Too Low");
            }

            chances--;

            if (chances > 0) {
                System.out.println("Remaining chances: " + chances);
            } else {
                System.out.println("Game Over!");
                System.out.println("The correct number was " + number);
            }
        }

        sc.close();
    }
}
