public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        // Handles an empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = (rows * columns) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert the 1D index to a 2D position
            int row = mid / columns;
            int col = mid % columns;

            if (matrix[row][col] == target) {
                return true;
            } 
            
            else if (matrix[row][col] < target) {
                left = mid + 1;
            } 
            
            else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        // Test cases
        System.out.println(searchMatrix(matrix, 3));   // true
        System.out.println(searchMatrix(matrix, 13));  // false

        System.out.println(searchMatrix(matrix, 11));   // true
        System.out.println(searchMatrix(matrix, 60));  // true
        System.out.println(searchMatrix(matrix, 16));  // true
        System.out.println(searchMatrix(matrix, 8));   // false

        int[][] oneElement = {{7}};
        System.out.println(searchMatrix(oneElement, 7)); // true
        System.out.println(searchMatrix(oneElement, 4)); // false

        int[][] oneRow = {{2, 4, 6, 8}};
        System.out.println(searchMatrix(oneRow, 6)); // true

        int[][] oneColumn = {{1},{3},{5}
        };
        System.out.println(searchMatrix(oneColumn, 3)); // true

        int[][] empty = {};
        System.out.println(searchMatrix(empty, 1)); // false
    }
}