import java.util.Scanner;
import java.util.Random;

public class Number_Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            playGame(random, scanner);

            System.out.print("Want to play again? (yes/no): ");
            String again = scanner.next().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static void playGame(Random random, Scanner scanner) {
        
        int secretNumber = random.nextInt(100) + 1;

        
        int maxAttempts = 10;
        int attempts = 0;
        int roundsPlayed = 0;
        int score = 0;

        while (true) {
            
            System.out.print("Guess the number between 1 and 100: ");
            int userGuess;

            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
            userGuess = scanner.nextInt();

            
            attempts++;
            if (userGuess == secretNumber) {
                System.out.println("Congratulations! Your guessed the correct number in " + attempts + " attempts.");
                score++;
                roundsPlayed++;
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }

            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum limit of attempts. The correct number was " + secretNumber + ".");
                roundsPlayed++;
                break;
            }
        }

        
        System.out.println("Your score: " + score + "/" + roundsPlayed + " rounds won.");
    }
}