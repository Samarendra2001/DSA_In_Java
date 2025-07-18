package Sliding_Window_Maximum;

// 🔹 Intuition
// We need to find the maximum element in every sliding window of size k.
// Instead of checking all elements in each window (which is inefficient), we use a Deque (Double-ended Queue) to keep track of useful elements.
// Deque helps in maintaining the order of elements efficiently by:
// Removing out-of-window elements from the front.
// Removing smaller elements from the back, as they are useless when a larger element enters the window.

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Edge case: If input is empty or invalid window size
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store max elements for each window
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices of elements

        for (int i = 0; i < n; i++) {
            
            // 1️⃣ Remove elements from the front that are out of the window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // Remove from the front
            }

            // 2️⃣ Remove smaller elements from the back since they won't be useful
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); // Remove from the back
            }

            // 3️⃣ Add the current element's index to the deque
            deque.offer(i);

            // 4️⃣ Store the maximum value of the current window in the result array
            if (i >= k - 1) { // Start storing results only when the first window is fully formed
                result[i - k + 1] = nums[deque.peek()]; // Peek gives the max element index
            }
        }

        return result;
    }
}

// **Main Class to Test the Solution**
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal case
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println("Max Sliding Window: " + Arrays.toString(solution.maxSlidingWindow(nums, k))); 
        // Expected Output: [3, 3, 5, 5, 6, 7]

        // Test Case 2: Single element
        int[] nums2 = {1};
        k = 1;
        System.out.println("Max Sliding Window: " + Arrays.toString(solution.maxSlidingWindow(nums2, k))); 
        // Expected Output: [1]

        // Test Case 3: All elements are the same
        int[] nums3 = {2, 2, 2, 2, 2};
        k = 2;
        System.out.println("Max Sliding Window: " + Arrays.toString(solution.maxSlidingWindow(nums3, k))); 
        // Expected Output: [2, 2, 2, 2]

        // Test Case 4: Decreasing numbers
        int[] nums4 = {9, 8, 7, 6, 5, 4, 3};
        k = 3;
        System.out.println("Max Sliding Window: " + Arrays.toString(solution.maxSlidingWindow(nums4, k))); 
        // Expected Output: [9, 8, 7, 6, 5]

        // Test Case 5: Increasing numbers
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7};
        k = 3;
        System.out.println("Max Sliding Window: " + Arrays.toString(solution.maxSlidingWindow(nums5, k))); 
        // Expected Output: [3, 4, 5, 6, 7]
    }
}

// 🔹 Explanation of Key Steps
// 1️⃣ Remove Out-of-Bounds Elements from the Front
// If an element is out of the current window, remove it from the front of the deque.
// 2️⃣ Remove Smaller Elements from the Back
// If the current element is greater than elements at the back, remove those elements.
// This ensures deque maintains only useful elements.
// 3️⃣ Add the Current Element
// Push the index of the current element into the deque.
// 4️⃣ Get the Maximum for Each Window
// Once the first window is fully formed (i >= k - 1), add the front of the deque to result (this is the max).
// 🔹 Why Use a Deque?
// Efficiently Removes Out-of-Bounds Elements → O(1)
// Maintains Order → Ensures max element is always at the front.
// Faster than Sorting or Nested Loops → O(N)