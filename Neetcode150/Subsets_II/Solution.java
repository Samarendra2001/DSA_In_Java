package Subsets_II;
// 📌 Intuition
// This is an extension of the subsets problem, but now duplicates exist in the input.
// Since order of elements doesn't matter, we must ensure no duplicate subsets are added.
// Sorting the input array helps us identify duplicate elements easily and skip them while generating subsets.
// We use Backtracking, but with an additional skip condition to avoid duplicate subsets.
// 💡 Approach
// Sort the array to make duplicates appear consecutively.
// Use backtracking to generate all subsets.
// Skip duplicates:
// Before including a number in the subset, check if it's a duplicate of the previous number.
// If it's a duplicate and not the first occurrence at the current level, skip it.
// Add the subset to the result list and recurse to the next element.

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to group duplicates together
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    /**
     * Recursive backtracking function to generate unique subsets.
     *
     * @param result  Stores all valid subsets
     * @param current Current subset being built
     * @param nums    Input array (sorted to handle duplicates)
     * @param start   Current starting index in nums array
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // ✅ Step 1: Add the current subset to the result
        result.add(new ArrayList<>(current));

        // ✅ Step 2: Iterate through the remaining elements
        for (int i = start; i < nums.length; i++) {
            // 🔹 Skip duplicate elements at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue; // Avoid duplicate subsets
            }

            // 🔹 Include nums[i] in the subset
            current.add(nums[i]);

            // 🔹 Recursive call to build further subsets
            backtrack(result, current, nums, i + 1);

            // 🔹 Backtrack: Remove the last element before next iteration
            current.remove(current.size() - 1);
        }
    }

    // ✅ Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2}; // Example input with duplicates
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);

        // ✅ Print the unique subsets
        System.out.println("Unique subsets: " + subsets);
    }
}

