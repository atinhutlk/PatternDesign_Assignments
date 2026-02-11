import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameCharacter c = new GameCharacter("Hero");

        while (!c.isMaster()) {
            c.printStatus();
            System.out.print("Choose action: ");
            String cmd = sc.nextLine().trim().toLowerCase();

            if (cmd.equals("train")) c.train();
            else if (cmd.equals("meditate")) c.meditate();
            else if (cmd.equals("fight")) c.fight();
            else System.out.println("Invalid!");

            System.out.println();
        }

        c.printStatus();
        System.out.println("Reached Master. Game ends!");
        sc.close();
    }
}
