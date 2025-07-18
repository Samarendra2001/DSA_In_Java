package Largest_Rectangle_In_Histogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0; // Stores the maximum area found
        Stack<Integer> stack = new Stack<>(); // Monotonic stack to store indices of heights
        int n = heights.length;

        // Iterate through all heights including one extra iteration (i = n) to clear the stack
        for (int i = 0; i <= n; i++) {
            // If we reached the last index, set currentHeight to 0 to clear remaining stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // Process the stack when the current height is smaller than the top of the stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // Pop the index of the height to calculate its area
                int height = heights[stack.pop()];

                // Determine the width of the rectangle where this height is the smallest
                int width;
                if (stack.isEmpty()) {
                    // If stack is empty, it means this height was the smallest in the entire left portion
                    // So, it extends from index 0 to i-1
                    width = i;
                } else {
                    // If stack is not empty, the popped height is bounded on the left by stack.peek()
                    // Width is (current index `i` - last smaller element index `stack.peek()`) - 1
                    width = i - stack.peek() - 1;
                }

                // Calculate area and update maxArea if it's larger
                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index onto the stack
            stack.push(i);
        }

        return maxArea; // Return the maximum area found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = solution.largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + result); // Expected Output: 10
    }
}

