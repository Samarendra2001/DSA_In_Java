package Number_Of_Islands;

// 🔹 Intuition
// The problem requires us to count the number of islands in a grid of '1's (land) and '0's (water).
// An island is a group of adjacent '1's (connected horizontally or vertically).

// 🔹 Approach
// Iterate through each cell in the grid.
// If the cell is '1' (land), increase the island count and start DFS to explore all connected land cells.
// DFS (Depth-First Search) Traversal:
// Change the current land cell '1' → '0' (mark it as visited).
// Recursively visit its four neighboring cells (up, down, left, right).
// Continue this process until all islands are counted.

public class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int islandCount = 0;

        // Traverse the entire grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If we find land ('1'), it's a new island
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(i, j, grid); // Explore the entire island
                }
            }
        }
        return islandCount;
    }

    private void dfs(int row, int col, char[][] grid) {
        int newRow = grid.length;
        int newCol = grid[0].length;

        // Define the four possible directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Base case: If out of bounds or at water ('0'), stop recursion
        if (row < 0 || col < 0 || row >= newRow || col >= newCol || grid[row][col] == '0') {
            return;
        }

        // Mark this cell as visited by changing it to '0'
        grid[row][col] = '0';

        // Explore all four possible directions
        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], grid);
        }
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands: " + solution.numIslands(grid));
    }
}

