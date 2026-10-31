public class PermutationChecker {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        return generate(s1, "", s2);
    }

    private static boolean generate (String remaining, String current, String s2) {

        // Base case: a complete permutation has been generated
        if (remaining.length() == 0) {
            return s2.contains(current);
        }

        // Choose each remaining character
        for (int i = 0; i < remaining.length(); i++) {

            char ch = remaining.charAt(i);

            String nextRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            String nextCurrent = current + ch;

            // Recursively generate the next permutation
            if (generate(nextRemaining, nextCurrent, s2)) {
                return true;
            }
        }

        return false;
    }
}