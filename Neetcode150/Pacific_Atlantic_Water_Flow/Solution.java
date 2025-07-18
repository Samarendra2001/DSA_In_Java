package Pacific_Atlantic_Water_Flow;

import java.util.*;

// 🚀 Problem Statement
// Given an m x n matrix heights where heights[r][c] represents the height of the cell at row r and column c, return a list of coordinates where water can flow to both the Pacific and Atlantic Oceans.

// Water can only flow from higher to lower OR same height.
// Pacific Ocean touches the left and top edges.
// Atlantic Ocean touches the right and bottom edges.
// 🧠 Intuition
// Reverse Thinking (DFS/BFS from Ocean)

// Instead of checking if each cell can reach both oceans, we start from both oceans and mark reachable cells.
// If a cell is reachable from both oceans, it is part of the result.
// Flood Fill (DFS or BFS)

// Start DFS from Pacific-border and mark cells that can flow to it.
// Start DFS from Atlantic-border and mark cells that can flow to it.
// Collect common cells (reachable from both oceans).
// 🔹 Optimized Approach (DFS)
// Initialize two boolean matrices (pacificReachable & atlanticReachable) to mark which cells can reach respective oceans.
// Run DFS from the ocean borders:
// First DFS from Pacific (left & top borders).
// Second DFS from Atlantic (right & bottom borders).
// Mark reachable cells in boolean matrices.
// Find common cells that can reach both oceans.
// ⏳ Time Complexity: O(m * n)
// 🛠 Space Complexity: O(m * n)


public class Solution {

    // DFS Approach to find cells that can flow to both Pacific and Atlantic Oceans
    public List<List<Integer>> pacificAtlanticDFS(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }

        int rows = heights.length;
        int cols = heights[0].length;

        // Arrays to track if a cell can reach Pacific or Atlantic
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Perform DFS for the Pacific Ocean (left and top borders)
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacificReachable, heights); // Left border
        }
        for (int j = 0; j < cols; j++) {
            dfs(0, j, pacificReachable, heights); // Top border
        }

        // Perform DFS for the Atlantic Ocean (right and bottom borders)
        for (int i = 0; i < rows; i++) {
            dfs(i, cols - 1, atlanticReachable, heights); // Right border
        }
        for (int j = 0; j < cols; j++) {
            dfs(rows - 1, j, atlanticReachable, heights); // Bottom border
        }

        // Collect the result where cells can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j)); // Add the coordinates to result
                }
            }
        }

        return result;
    }

    // DFS Helper function
    private void dfs(int row, int col, boolean[][] reachable, int[][] heights) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // Directions for right, down, left, and up

        reachable[row][col] = true; // Mark current cell as reachable

        // Explore all 4 neighboring cells
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Boundary check
            if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
                continue; // Skip if out of bounds
            }

            // Skip already visited cells or cells that can't be reached
            if (reachable[newRow][newCol] || heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(newRow, newCol, reachable, heights); // Recursive DFS call for valid neighbor
        }
    }

    // BFS Approach to find cells that can flow to both Pacific and Atlantic Oceans
    public List<List<Integer>> pacificAtlanticBFS(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }

        int rows = heights.length;
        int cols = heights[0].length;

        // Arrays to track if a cell can reach Pacific or Atlantic
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Perform BFS for Pacific Ocean (left and top borders)
        Queue<int[]> pacificQueue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            pacificQueue.offer(new int[]{i, 0}); // Left border
        }
        for (int j = 0; j < cols; j++) {
            pacificQueue.offer(new int[]{0, j}); // Top border
        }

        bfs(pacificQueue, pacificReachable, heights); // Process Pacific Ocean borders

        // Perform BFS for Atlantic Ocean (right and bottom borders)
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            atlanticQueue.offer(new int[]{i, cols - 1}); // Right border
        }
        for (int j = 0; j < cols; j++) {
            atlanticQueue.offer(new int[]{rows - 1, j}); // Bottom border
        }

        bfs(atlanticQueue, atlanticReachable, heights); // Process Atlantic Ocean borders

        // Collect the result where cells can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j)); // Add the coordinates to result
                }
            }
        }

        return result;
    }

    // BFS Helper function
    private void bfs(Queue<int[]> queue, boolean[][] reachable, int[][] heights) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // Directions for right, down, left, and up

        // Process the queue until it's empty
        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); // Get the front element in the queue
            int row = cell[0], col = cell[1];

            reachable[row][col] = true; // Mark the cell as reachable

            // Explore all 4 neighboring cells
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Boundary check
                if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
                    continue; // Skip if out of bounds
                }

                // Skip already visited cells or cells that can't be reached
                if (reachable[newRow][newCol] || heights[newRow][newCol] < heights[row][col]) {
                    continue;
                }

                queue.offer(new int[]{newRow, newCol}); // Add the neighbor to the queue
            }
        }
    }
    public static void main(String[] args) {
        // Example input grid representing the heights
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        // Create Solution object to access both DFS and BFS methods
        Solution solution = new Solution();

        // Using DFS to find the result
        List<List<Integer>> resultDFS = solution.pacificAtlanticDFS(heights);
        System.out.println("DFS Result: " + resultDFS);

        // Using BFS to find the result
        List<List<Integer>> resultBFS = solution.pacificAtlanticBFS(heights);
        System.out.println("BFS Result: " + resultBFS);
    }
}

