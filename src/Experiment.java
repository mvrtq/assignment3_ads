import java.util.Random;
import java.util.Arrays;

public class Experiment {

    private static final Random rand = new Random();

    public static boolean isSorted(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static int[] generateRandom(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }

    public static int[] generateSorted(int size) {
        int[] arr = generateRandom(size);
        Arrays.sort(arr);
        return arr;
    }

    public static int[] generateReverse(int size) {
        int[] arr = generateSorted(size);

        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }

        return arr;
    }

    public static int[] generateDuplicates(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size / 10 + 1);
        }
        return arr;
    }

    public static void run() {
        int[] sizes = {1000, 5000, 10000};
        int runs = 5;

        for (int size : sizes) {
            System.out.println("\n=== Array size: " + size + " ===");

            int[] arrRandom = generateRandom(size);
            int[] arrSorted = generateSorted(size);
            int[] arrReverse = generateReverse(size);
            int[] arrDup = generateDuplicates(size);

            int target = arrSorted[rand.nextInt(size)];

            System.out.println("\n-- Random data --");
            measureSort("Bubble Sort", arrRandom, runs);
            measureSort("Merge Sort", arrRandom, runs);
            measureSearch(arrSorted, runs, target);

            System.out.println("\n-- Sorted data --");
            measureSort("Bubble Sort", arrSorted, runs);
            measureSort("Merge Sort", arrSorted, runs);
            measureSearch(arrSorted, runs, target);

            System.out.println("\n-- Reverse data --");
            measureSort("Bubble Sort", arrReverse, runs);
            measureSort("Merge Sort", arrReverse, runs);
            measureSearch(arrSorted, runs, target);

            System.out.println("\n-- Duplicates data --");
            measureSort("Bubble Sort", arrDup, runs);
            measureSort("Merge Sort", arrDup, runs);
            measureSearch(arrSorted, runs, target);
        }
    }

    private static void measureSort(String type, int[] original, int runs) {
        long total = 0;

        for (int i = 0; i < runs; i++) {
            int[] copy = Arrays.copyOf(original, original.length);

            long start = System.nanoTime();

            if (type.equals("Bubble Sort")) {
                Sorter.bubbleSort(copy);
            } else {
                Sorter.mergeSort(copy);
            }

            long end = System.nanoTime();
            total += (end - start);

            if (!isSorted(copy)) {
                System.out.println("Sorting error in " + type);
            }
        }

        System.out.println(type + ": " + (total / runs) + " ns");
    }

    private static void measureSearch(int[] sortedArr, int runs, int target) {
        long total = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            Searcher.binarySearch(sortedArr, target);
            long end = System.nanoTime();

            total += (end - start);
        }

        System.out.println("Binary Search: " + (total / runs) + " ns");
    }
}