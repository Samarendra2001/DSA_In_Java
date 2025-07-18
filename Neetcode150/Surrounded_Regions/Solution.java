package Surrounded_Regions;
// Intuition
// The problem requires capturing all regions of 'O' that are completely surrounded by 'X' on all four sides. However, 'O's that are connected to the boundary cannot be converted to 'X'.
// Thus, the main idea is:

// Identify 'O's connected to the boundary.
// Protect these boundary 'O's from being converted.
// Convert all remaining 'O's to 'X'.
// Approach
// Identify and mark boundary-connected 'O's:
// Perform DFS (Depth First Search) from all boundary 'O's and mark them as 'T' (temporary marker).
// Convert remaining 'O's to 'X':
// Any 'O' that was not marked 'T' must be surrounded, so convert it to 'X'.
// Revert 'T' back to 'O':
// The 'T' markers represent safe 'O's, so convert them back to 'O'.

public class Solution {
    public void solve(char[][] board) {
        // Edge case: If board is empty, return immediately
        if (board == null || board.length == 0) return;
        
        int m = board.length, n = board[0].length; // Get dimensions of the board

        // Step 1: Identify and mark all boundary-connected 'O' cells as 'T'
        for (int i = 0; i < m; i++) { // Traverse first and last column
            for (int j = 0; j < n; j++) {
                // Only process 'O' cells at the boundary
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j); // Perform DFS from boundary 'O'
                }
            }
        }

        // Step 2: Convert all remaining 'O' cells to 'X' (they are surrounded)
        // Step 3: Convert all 'T' back to 'O' (safe ones)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded 'O' is flipped to 'X'
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'; // Restore temporary 'T' back to 'O'
                }
            }
        }
    }

    // Helper function: DFS traversal to mark boundary-connected 'O' as 'T'
    private void dfs(char[][] board, int i, int j) {
        // Base condition: Stop if out of bounds or already visited/non-'O' cell
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }

        // Mark this cell as 'T' to indicate it is connected to the boundary
        board[i][j] = 'T';

        // Explore all 4 possible directions
        dfs(board, i + 1, j); // Down
        dfs(board, i - 1, j); // Up
        dfs(board, i, j + 1); // Right
        dfs(board, i, j - 1); // Left
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        System.out.println("Before solving:");
        printBoard(board);

        solution.solve(board);

        System.out.println("After solving:");
        printBoard(board);
    }

    // Helper function to print the board
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(new String(row));
        }
        System.out.println();
    }
}
//using BFS
// import java.util.*;

// public class SolutionBFS {
//     public void solve(char[][] board) {
//         if (board == null || board.length == 0) return;
        
//         int m = board.length, n = board[0].length;
//         Queue<int[]> queue = new LinkedList<>();
        
//         // Step 1: Add all boundary 'O' cells to queue and mark as 'T'
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
//                     queue.add(new int[]{i, j});
//                     board[i][j] = 'T'; // Mark as visited
//                 }
//             }
//         }

//         // Define possible directions (Up, Down, Left, Right)
//         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
//         // Step 2: BFS traversal
//         while (!queue.isEmpty()) {
//             int[] cell = queue.poll();
//             int row = cell[0], col = cell[1];

//             for (int[] dir : directions) {
//                 int newRow = row + dir[0];
//                 int newCol = col + dir[1];

//                 // If within bounds and is 'O', mark as 'T' and add to queue
//                 if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'O') {
//                     board[newRow][newCol] = 'T';
//                     queue.add(new int[]{newRow, newCol});
//                 }
//             }
//         }

//         // Step 3: Convert remaining 'O' to 'X' and 'T' back to 'O'
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (board[i][j] == 'O') {
//                     board[i][j] = 'X';
//                 } else if (board[i][j] == 'T') {
//                     board[i][j] = 'O';
//                 }
//             }
//         }
//     }
// }

