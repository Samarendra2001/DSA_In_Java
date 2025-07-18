package Permutations;
// 🔹 Approach
// Use a boolean used[] array to track which numbers are already chosen in the current permutation.
// Backtrack function:
// If the current permutation list reaches the size of nums, we store it in the result.
// Otherwise, loop through all numbers:
// If a number is not used, add it to the current list and mark it as used[] = true.
// Recursively call the function to build further.
// Backtrack by removing the last number and marking it as used[] = false to try other possibilities.
// Base Case: When current has all nums.length elements, store it.


import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // Track used elements
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        // ✅ Base Case: If permutation is complete, add to result
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Store current permutation
            return;
        }

        // 🔄 Try all numbers in nums
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // If number is not used, pick it
                current.add(nums[i]); // Choose the number
                used[i] = true; // Mark it as used
                
                // 🔁 Recursive call to build the rest of the permutation
                backtrack(result, current, nums, used);
                
                // ♻️ Backtrack: Undo the choice to try another number
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};

        System.out.println("All permutations of " + Arrays.toString(nums) + ":");
        System.out.println(solution.permute(nums));
    }
}

