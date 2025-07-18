package Longest_Consecutive_Sequence;

import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        // If the array is empty, return 0 as no sequence exists
        if (nums.length == 0) {
            return 0;
        }

        // Create a HashSet to store unique elements from the array
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        // Initialize the variable to track the longest consecutive subsequence
        int longestSub = 1;

        // Iterate through the set of numbers
        for (int num : numSet) {
            // If the current number has a predecessor (num - 1) in the set,
            // skip it as it's already part of another sequence
            if (numSet.contains(num - 1)) {
                continue;
            }

            // Start a new sequence if the number is the start of a consecutive sequence
            int currentNum = num; // Track the current number in the sequence
            int currentSub = 1; // Count the length of the current sequence

            // Check if the next consecutive number exists in the set
            while (numSet.contains(currentNum + 1)) {
                currentNum++; // Move to the next number in the sequence
                currentSub++; // Increase the length of the sequence
            }

            // Update the longestSub if the current sequence is longer
            longestSub = Math.max(longestSub, currentSub);
        }

        // Return the length of the longest consecutive sequence
        return longestSub;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 0, 1, 2, 3, 4, 6};
        int[] nums3 = {};

        System.out.println("Longest Consecutive Sequence (nums1): " + sol.longestConsecutive(nums1));
        System.out.println("Longest Consecutive Sequence (nums2): " + sol.longestConsecutive(nums2));
        System.out.println("Longest Consecutive Sequence (nums3): " + sol.longestConsecutive(nums3));
    }
}
