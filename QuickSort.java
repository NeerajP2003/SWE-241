public class QuickSort {

    public static void sort(char[] letters) {
        quickSort(letters, 0, letters.length - 1);
    }

    private static void quickSort(char[] letters, int low, int high) {

        // Base case checks if Array has 0 or 1 character
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(letters, low, high);

        quickSort(letters, low, pivotIndex - 1);
        quickSort(letters, pivotIndex + 1, high);

    }

    private static int partition(char[] letters, int low, int high) {
        char pivot = letters[high];
        int i = low - 1;

    for (int j = low; j < high; j++) {
        if (letters[j] < pivot) {
            i++;

            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
    }

    int pivotIndex = i + 1;

    char temp = letters[pivotIndex];
    letters[pivotIndex] = letters[high];
    letters[high] = temp;

    return pivotIndex;
}

public static String sortString(String str) {
    char[] letters = str.toCharArray();
    sort(letters);
    return new String(letters);
}

}

    

