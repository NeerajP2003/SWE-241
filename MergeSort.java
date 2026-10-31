public class MergeSort {

    public static void sort(char[] letters) {

        // Base case checks if Array has 0 or 1 character
        if (letters.length <= 1) {
            return;
        }

        int mid = letters.length / 2;

        char[] left = new char[mid];
        char[] right = new char[letters.length - mid];

        // Copies both halves of the array into separate left and right arrays
        for (int i = 0; i < mid; i++) {
            left[i] = letters[i];
        }

        for (int i = mid; i < letters.length; i++) {
            right[i - mid] = letters[i];
        }

        // Sorts both halves recursively
        sort(left);
        sort(right);

        // Merges sorted halves
        merge(letters, left, right);
    }

    private static void merge(char[] letters, char[] left, char[] right) {

        int i = 0;
        int j = 0;
        int k = 0;

        // Compares and copies characters from both halves
        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                letters[k] = left[i];
                i++;
                k++;
            } 
            
            else {
                letters[k] = right[j];
                j++;
                k++;
            }
        }

        // Copies remaining characters from both halves
        while (i < left.length) {
            letters[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            letters[k] = right[j];
            j++;
            k++;
        }
    }

    public static String sortString(String str) {

    // Converts string to character array
    char[] letters = str.toCharArray();

    // Sorts character array
    sort(letters);

    // Returns sorted array as a string
    return new String(letters);
   }
}