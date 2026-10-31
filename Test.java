
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        // Task 1: Permutation test cases
        System.out.println("Permutation tests:");

        System.out.println(PermutationChecker.checkInclusion("ab", "eidbaooo"));  // true
        System.out.println(PermutationChecker.checkInclusion("ab", "eidboaoo"));  // false
        System.out.println(PermutationChecker.checkInclusion("adc", "dcda"));     // true
        System.out.println(PermutationChecker.checkInclusion("a", "ab"));         // true
        System.out.println(PermutationChecker.checkInclusion("abc", "ab"));       // false
        System.out.println(PermutationChecker.checkInclusion("aab", "eidbaaoo")); // true

        // Task 2: Eight Queens test cases
        System.out.println("\nEight Queens tests:");

        System.out.println(EightQueens.minimumMoves(new int[]{1, 2, 3, 4, 5, 6, 7, 8})); // 7

        System.out.println(EightQueens.minimumMoves(new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // 7

        System.out.println(EightQueens.minimumMoves(new int[]{1, 5, 8, 6, 3, 7, 2, 4})); // 0

        // Optional: read a custom input from the terminal
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter 8 integers for another test:");

        int[] rows = new int[8];

        for (int i = 0; i < 8; i++) {
            rows[i] = scanner.nextInt();
        }

        System.out.println("Minimum moves: " + EightQueens.minimumMoves(rows));

        scanner.close();
    }
}