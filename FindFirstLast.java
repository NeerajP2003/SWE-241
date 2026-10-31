import java.util.Arrays;

public class FindFirstLast {

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] {first, last};
    }

    public static int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } 
            
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } 
            
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Test cases
        int[] nums1 = {4, 9, 10, 17, 17, 17, 19, 21};
        System.out.println(Arrays.toString(searchRange(nums1, 17)));

        int[] nums2 = {2, 4, 6, 8, 10, 14, 16};
        System.out.println(Arrays.toString(searchRange(nums2, 12)));

        int[] nums3 = {};
        System.out.println(Arrays.toString(searchRange(nums3, 0)));

        int[] nums4 = {5, 5, 5, 5, 5};
        System.out.println(Arrays.toString(searchRange(nums4, 5)));

        int[] nums5 = {1, 2, 2, 2, 3, 4};
        System.out.println(Arrays.toString(searchRange(nums5, 2)));
    }
}