import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Recommendation> list = new ArrayList<>();

        Recommendation r1 = new Recommendation("Students who like self-development");
        r1.addBook(new Book("Atomic Habits", "James Clear"));
        r1.addBook(new Book("Deep Work", "Cal Newport"));
        list.add(r1);

        Recommendation r2 = new Recommendation("People interested in business");
        r2.addBook(new Book("Rich Dad Poor Dad", "Robert Kiyosaki"));
        r2.addBook(new Book("The Lean Startup", "Eric Ries"));
        list.add(r2);

        while (true) {
            System.out.println("\n1. View recommendations");
            System.out.println("2. Clone recommendation");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("\nRecommendation " + (i + 1));
                    list.get(i).display();
                }
            } else if (choice == 2) {
                System.out.print("Choose recommendation number to clone: ");
                int index = sc.nextInt() - 1;
                sc.nextLine();

                Recommendation cloned = list.get(index).clone();

                System.out.print("Enter new target audience: ");
                cloned.setTargetAudience(sc.nextLine());

                System.out.print("Enter one more book title: ");
                String title = sc.nextLine();
                System.out.print("Enter author: ");
                String author = sc.nextLine();

                cloned.addBook(new Book(title, author));
                list.add(cloned);

                System.out.println("New recommendation saved.");
            } else if (choice == 3) {
                System.out.println("Program ended.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}