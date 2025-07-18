package Rotten_Oranges;
// Intuition
// We have a grid where:
// 0 represents an empty cell.
// 1 represents a fresh orange.
// 2 represents a rotten orange.
// Goal: Find the minimum time required to rot all fresh oranges.
// Rotten oranges spread to adjacent fresh oranges in 1 minute.
// We must simulate this process and determine the total time taken.
// Key Observations
// All fresh oranges must eventually rot. If any fresh orange remains isolated, return -1.
// Breadth-First Search (BFS) is ideal since all adjacent oranges rot at the same time.
// Approach
// Initialize BFS Queue:
// Count fresh oranges.
// Store initial positions of rotten oranges in a queue.
// Perform BFS:
// Each level in BFS represents 1 minute.
// Spread rot to all 4 adjacent cells (up, down, left, right).
// Keep track of time taken and reduce fresh orange count.
// Check if all fresh oranges are rotten:
// If all fresh oranges rot, return minutes - 1 (since the last minute is extra).
// If some fresh oranges remain, return -1.

import java.util.*;

public class Solution {
    public int orangesRotting(int[][] grid) {
        // Step 1: Handle Edge Case - If the grid is empty, return -1
        if (grid == null || grid.length == 0) return -1;

        int m = grid.length, n = grid[0].length; // Get the grid dimensions
        int freshCount = 0; // Count the number of fresh oranges
        Queue<int[]> rottenQueue = new LinkedList<>(); // Queue to store the rotten oranges' positions

        // Step 2: Traverse the grid to find initial rotten and fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++; // Count fresh oranges
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j}); // Store rotten oranges' positions in queue
                }
            }
        }

        // If there are no fresh oranges, return 0 (no time needed)
        if (freshCount == 0) return 0;

        int minutes = 0; // Timer to track the time taken to rot all oranges
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4 possible directions (up, down, left, right)

        // Step 3: Start BFS to spread rot
        while (!rottenQueue.isEmpty()) {
            int size = rottenQueue.size(); // Number of rotten oranges at current minute
            boolean rotted = false; // Track if any fresh orange rots in this round

            for (int i = 0; i < size; i++) {
                int[] rotten = rottenQueue.poll(); // Get the current rotten orange
                int r = rotten[0], c = rotten[1]; // Row and Column position of the rotten orange

                // Explore all 4 adjacent directions
                for (int[] dir : directions) {
                    int x = r + dir[0]; // New row
                    int y = c + dir[1]; // New column

                    // Check if the adjacent cell is within bounds and is a fresh orange
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // Turn the fresh orange to rotten
                        freshCount--; // Reduce fresh orange count
                        rottenQueue.offer(new int[]{x, y}); // Add this newly rotten orange to queue
                        rotted = true; // Mark that we rotted at least one orange
                    }
                }
            }

            // Only increase the time if at least one orange was rotted
            if (rotted) minutes++;
        }

        // Step 4: Check if all fresh oranges have been rotted
        return freshCount == 0 ? minutes : -1;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        System.out.println("Minutes required: " + solution.orangesRotting(grid));
    }
}


// Alternative Approach: Multi-source BFS using a Set
// Intuition
// Instead of using a queue, we can use a set to track rotten oranges.
// This avoids extra queue operations but has the same complexity.
// Code
// import java.util.*;

// public class SolutionSet {
//     public int orangesRotting(int[][] grid) {
//         if (grid == null || grid.length == 0) return -1;

//         int m = grid.length, n = grid[0].length;
//         Set<int[]> rottenSet = new HashSet<>();
//         int freshCount = 0;

//         // Step 1: Identify all fresh and rotten oranges
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == 1) freshCount++;
//                 else if (grid[i][j] == 2) rottenSet.add(new int[]{i, j});
//             }
//         }

//         if (freshCount == 0) return 0; // No fresh oranges

//         int minutes = 0;
//         int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//         // Step 2: Process rotting using BFS with a set
//         while (!rottenSet.isEmpty()) {
//             Set<int[]> newRotten = new HashSet<>();
//             for (int[] rotten : rottenSet) {
//                 for (int[] dir : directions) {
//                     int x = rotten[0] + dir[0];
//                     int y = rotten[1] + dir[1];

//                     if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
//                         grid[x][y] = 2;
//                         freshCount--;
//                         newRotten.add(new int[]{x, y});
//                     }
//                 }
//             }

//             if (newRotten.isEmpty()) break; // No more oranges to rot
//             rottenSet = newRotten;
//             minutes++;
//         }

//         return freshCount == 0 ? minutes : -1;
//     }
// }
