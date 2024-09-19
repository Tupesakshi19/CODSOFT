import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        while (true) {
            int numberToGuess = random.nextInt(100) + 1; // Generate a number between 1 and 100
            int attempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");

            while (attempts > 0) {
                System.out.print("You have " + attempts + " attempts left. Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number!");
                    guessedCorrectly = true;
                    totalScore++;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                attempts--;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your total score is: " + totalScore);
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your final score is: " + totalScore);
                break;
            }
        }

        scanner.close();
    }
}
