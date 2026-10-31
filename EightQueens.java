public class EightQueens {

    private static final int N = 8;

    private static int[] original = new int[N];
    private static int[] placement = new int[N];

    private static int maxUnchanged = 0;

    public static int minimumMoves(int[] rows) {

        original = rows.clone();
        placement = new int[N];
        maxUnchanged = 0;

        solve(0, 0);

        return N - maxUnchanged;
    }

    private static void solve(int col, int unchanged) {

        // All eight queens have been placed
        if (col == N) {
            if (unchanged > maxUnchanged) {
                maxUnchanged = unchanged;
            }
            return;
        }

        // Try every row in the current column
        for (int row = 1; row <= N; row++) {

            if (isSafe(row, col)) {

                placement[col] = row;

                int newUnchanged = unchanged;

                if (row == original[col]) {
                    newUnchanged++;
                }

                solve(col + 1, newUnchanged);
            }
        }
    }

    private static boolean isSafe(int row, int col) {

        // Check queens placed in earlier columns
        for (int prevCol = 0; prevCol < col; prevCol++) {

            int prevRow = placement[prevCol];

            // Same row
            if (prevRow == row) {
                return false;
            }

            // Same diagonal
            if (Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }

        return true;
    }
}