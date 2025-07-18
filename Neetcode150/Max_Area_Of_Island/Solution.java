package Max_Area_Of_Island;

// 🧠 Intuition
// We need to explore all 1s in the grid and count how many 1s are connected together.
// We can use Depth-First Search (DFS) to traverse each island, counting its area.
// If we find a 1, we explore in all 4 directions and count how many 1s we visit.
// We track the maximum area found.
// 🔹 Approach
// Loop through every cell in the grid.
// If the cell is 1, start a DFS search to calculate the island's area.
// Mark visited cells as 0 to avoid counting them again.
// Keep track of the largest island area found.

import java.util.*;

public class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        // If grid is empty, return 0 (edge case)
        if (grid == null || grid.length == 0) return 0;

        int maxArea = 0; // Variable to store the maximum area

        // Iterate through every cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // If we find a land cell (1), start DFS
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j); // Get the island's area using DFS
                    maxArea = Math.max(maxArea, area); // Update the max area if needed
                }
            }
        }
        return maxArea; // Return the largest island area found
    }

    private int dfs(int[][] grid, int i, int j) {
        // Base case: If out of bounds OR cell is water (0), return 0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // Mark the cell as visited by changing it to '0'
        int area = 1; // Count the current cell as part of the island

        // Explore all 4 possible directions (up, down, left, right)
        area += dfs(grid, i + 1, j); // Move Down
        area += dfs(grid, i - 1, j); // Move Up
        area += dfs(grid, i, j + 1); // Move Right
        area += dfs(grid, i, j - 1); // Move Left

        return area; // Return the computed island area
    }
    public static void main(String[] args) {
        // Example input grid
        int[][] grid = {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 0, 0, 0}
        };

        // Create an instance of Solution class
        Solution solution = new Solution();

        // Call maxAreaOfIsland function and print the result
        int maxArea = solution.maxAreaOfIsland(grid);
        System.out.println("Maximum Area of Island: " + maxArea);
    }
}

// Recursive calls to visit 4 directions

// Move Down: dfs(grid, i + 1, j)
// Move Up: dfs(grid, i - 1, j)
// Move Right: dfs(grid, i, j + 1)
// Move Left: dfs(grid, i, j - 1)
// ⏳ Time Complexity
// O(R × C), where R = rows, C = columns.
// Each cell is visited once in the worst case.
// 🛠 Space Complexity
// O(R × C) (recursive call stack in worst case).