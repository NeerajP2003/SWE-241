import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AnagramGrouper {

    public static List<List<String>> groupAnagram(List<String> strings) {
        return groupAnagram(strings, false);
    }

    public static List<List<String>> groupAnagram(List<String> strings, boolean useQuickSort) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strings) {
            String key;

            // Got recommendation from chatGPT 
            if (useQuickSort) {
                key = QuickSort.sortString(word);
            } 
            
            else {
                key = MergeSort.sortString(word);
            }

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}