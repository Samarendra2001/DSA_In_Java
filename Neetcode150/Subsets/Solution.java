package Subsets;

import java.util.*;
// 📌 Intuition
// A subset is a selection of elements from an array, including the empty set and the full array.
// The total number of subsets for an array of size N is 2^N.
// We can generate all subsets using backtracking by:
// Including an element in the current subset.
// Skipping an element and moving forward.
// 💡 Approach
// Start with an empty subset and an index 0.
// At each index, we add the current subset to the result.
// For each number:
// Include it in the subset.
// Recurse to explore further elements.
// Backtrack (remove the element) to try the next possibility.
// Repeat until all subsets are generated.

public class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  // List to store all subsets
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    /**
     * Recursive function to generate all subsets using backtracking.
     * 
     * @param index   Current index in nums array
     * @param nums    Input array
     * @param current Current subset being built
     * @param result  List storing all subsets
     */
    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // ✅ Step 1: Add the current subset to the result list (Deep copy to avoid modifications)
        result.add(new ArrayList<>(current));

        // ✅ Step 2: Iterate over remaining elements
        for (int i = index; i < nums.length; i++) {
            // 🔹 Include nums[i] in the subset
            current.add(nums[i]);

            // 🔹 Recurse to generate subsets including this element
            generateSubsets(i + 1, nums, current, result);

            // 🔹 Backtrack: Remove the last element added to try the next possibility
            current.remove(current.size() - 1);
        }
    }

    // ✅ Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};  // Example input array
        List<List<Integer>> subsets = solution.subsets(nums);

        // ✅ Print the subsets
        System.out.println("All subsets: " + subsets);
    }
}
// Output:  [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
