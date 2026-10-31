import java.util.Arrays;
import java.util.List;

public class Main {

    public static void comparePerformance(String input) {
    int repetitions = 1000;

    // Test Merge Sort (Used ChatGPT's suggestion of nanoTime and took its help of constructing this method)
    long mergeStart = System.nanoTime();

    for (int i = 0; i < repetitions; i++) {
        MergeSort.sortString(input);
    }

    long mergeEnd = System.nanoTime();

    // Test Quick Sort
    long quickStart = System.nanoTime();

    for (int i = 0; i < repetitions; i++) {
        QuickSort.sortString(input);
    }

    long quickEnd = System.nanoTime();

    long mergeTime = mergeEnd - mergeStart;
    long quickTime = quickEnd - quickStart;

    System.out.println("Input length: " + input.length());
    System.out.println("Merge Sort average: " + mergeTime / repetitions + " ns");
    System.out.println("Quick Sort average: " + quickTime / repetitions + " ns");
    System.out.println();
}
    public static void main(String[] args) {

        List<String> terms = Arrays.asList("rat", "tar", "art", "cat", "act");

        List<String> items = Arrays.asList("bucket", "rat", "mango", "tango", "ogtan", "tar");

        List<String> test = Arrays.asList("dog", "cat", "dog");

        // Tests with Merge Sort
        System.out.println(MergeSort.sortString("mango"));
        System.out.println(MergeSort.sortString("ogman"));
        System.out.println(MergeSort.sortString("banana"));
        System.out.println(MergeSort.sortString(""));

        System.out.println(AnagramGrouper.groupAnagram(terms, false));
        System.out.println(AnagramGrouper.groupAnagram(items, false));
        System.out.println(AnagramGrouper.groupAnagram(test, false));

        // Tests with Quick Sort
        System.out.println(QuickSort.sortString("mango"));
        System.out.println(QuickSort.sortString("rat"));
        System.out.println(QuickSort.sortString(""));

        System.out.println(AnagramGrouper.groupAnagram(terms, true));
        System.out.println(AnagramGrouper.groupAnagram(items, true));
        System.out.println(AnagramGrouper.groupAnagram(test, true));

        // Performance Tests
        System.out.println("Performance Comparison");
        comparePerformance("mango");
        comparePerformance("abcdefghijklmnopqrstuvwxyz");
        comparePerformance("zyxwvutsrqponmlkjihgfedcba");
    }
}