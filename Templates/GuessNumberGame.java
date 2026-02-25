import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame extends Game {

    private int secretNumber;
    private boolean finished;
    private int winnerPlayer; 
    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        secretNumber = new Random().nextInt(100) + 1; // 1..100
        finished = false;
        winnerPlayer = -1;
        scanner = new Scanner(System.in);

        System.out.println("=== GUESS THE NUMBER ===");
        System.out.println("The computer picked a number from 1 to 100.");
        System.out.println("Players take turns guessing. The first correct guess wins.");
    }

    @Override
    public boolean endOfGame() {
        return finished;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.print("\nPlayer " + (player + 1) + ", enter your guess: ");
        int guess = scanner.nextInt();

        if (guess == secretNumber) {
            System.out.println("Correct!");
            finished = true;
            winnerPlayer = player;
        } else if (guess < secretNumber) {
            System.out.println("Too low.");
        } else {
            System.out.println("Too high.");
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("\n=== GAME OVER ===");
        System.out.println("The secret number was: " + secretNumber);

        if (winnerPlayer != -1) {
            System.out.println("Winner: Player " + (winnerPlayer + 1));
        } else {
            System.out.println("No winner.");
        }
    }
}