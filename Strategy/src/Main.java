import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] small = new int[30];
        int[] large = new int[20000];

        for (int i = 0; i < small.length; i++) small[i] = random.nextInt(1000);
        for (int i = 0; i < large.length; i++) large[i] = random.nextInt(100000);

        test("Bubble Sort", new BubbleSortStrategy(), small, large);
        test("Insertion Sort", new InsertionSortStrategy(), small, large);
        test("Heap Sort", new HeapSortStrategy(), small, large);
    }

    public static void test(String name, SortStrategy strategy, int[] small, int[] large) {
        SortContext context = new SortContext(strategy);

        int[] a = Arrays.copyOf(small, small.length);
        long start1 = System.nanoTime();
        context.executeSort(a);
        long end1 = System.nanoTime();

        int[] b = Arrays.copyOf(large, large.length);
        long start2 = System.nanoTime();
        context.executeSort(b);
        long end2 = System.nanoTime();

        System.out.println(name);
        System.out.println("Small array: " + (end1 - start1) + " ns");
        System.out.println("Large array: " + (end2 - start2) + " ns");
        System.out.println();
    }
}