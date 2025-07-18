package Word_Search;
// 📌 Intuition
// We need to search for the word in the 2D grid.
// The problem can be solved using DFS (Depth-First Search) with backtracking:
// Try placing each character of the word in the grid.
// Move in 4 possible directions (left, right, up, down).
// Backtrack if we hit a dead-end.
// Use a temporary marker (#) to avoid revisiting the same cell.
// 💡 Approach
// Iterate through each cell in the board.
// If a cell matches the first letter of the word, start DFS (backtracking) from that cell.
// In the backtracking function:
// Check boundary conditions (if we go out of bounds).
// Check if the current cell matches the letter at index in word.
// Mark the cell as visited (#) to avoid reusing it in the same path.
// Try moving in all 4 directions.
// If any path leads to a solution, return true.
// Backtrack by restoring the original character.
// If no path is found, return false.
class Solution {

    // Global variables to store board dimensions
    public char[][] board;
    public int rows;
    public int cols;

    // Main function to check if a word exists in the board
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;    // Get the total number of rows
        this.cols = board[0].length; // Get the total number of columns

        // Loop through every cell in the board to find the starting letter
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If the first letter of the word matches, start searching
                if (backtrack(r, c, word, 0)) {
                    return true; // If a valid path is found, return true
                }
            }
        }

        return false; // If no path is found, return false
    }

    // Recursive function to search for the word using backtracking
    public boolean backtrack(int row, int col, String word, int index) {

        // ✅ Base Case: If we have matched all letters in the word
        if (index == word.length()) {
            return true; // We successfully found the word
        }

        // ✅ Boundary conditions:
        // 1. Check if we are out of bounds (row or column is invalid)
        // 2. Check if the current cell does NOT match the letter we need
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)) {
            return false; // Stop and return false if the conditions are not met
        }

        // ✅ Store the current character before modifying the board
        char temp = board[row][col];

        // ✅ Mark the cell as visited by changing it to a placeholder (e.g., '#')
        board[row][col] = '#';

        // ✅ Define the 4 possible directions we can move (Right, Down, Left, Up)
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};

        // ✅ Try moving in all 4 directions
        boolean found = false; // Variable to check if the word is found
        for (int d = 0; d < 4; d++) {
            int newRow = row + rowDir[d]; // Compute new row position
            int newCol = col + colDir[d]; // Compute new column position

            // Call the function recursively for the next character in the word
            found = backtrack(newRow, newCol, word, index + 1);

            // If a path is found, exit the loop
            if (found) {
                break;
            }
        }

        // ✅ Restore the original character (Backtracking step)
        board[row][col] = temp;

        return found; // Return whether we found a valid path
    }
     // Main method to test the solution
     public static void main(String[] args) {
        Solution solution = new Solution();

        // Define the board
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        // Define test cases
        String word1 = "ABCCED"; // Expected output: true
        String word2 = "SEE";    // Expected output: true
        String word3 = "ABCB";   // Expected output: false

        // Run tests and print results
        System.out.println("Word: " + word1 + " → Exists: " + solution.exist(board, word1));
        System.out.println("Word: " + word2 + " → Exists: " + solution.exist(board, word2));
        System.out.println("Word: " + word3 + " → Exists: " + solution.exist(board, word3));
    }
}

