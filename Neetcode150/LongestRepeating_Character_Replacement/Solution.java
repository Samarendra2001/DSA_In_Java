package LongestRepeating_Character_Replacement;

public class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; // Left boundary of the sliding window
        int maxFreq = 0; // Stores the max frequency of a single character in the window
        int[] charCount = new int[26]; // Array to track character frequencies in the current window
        int maxLength = 0; // Stores the result: the length of the longest valid substring

        for (int right = 0; right < s.length(); right++) { // Expand the window with `right`
            // Increment the count for the character at index `right`
            charCount[s.charAt(right) - 'A']++;
            // Update the max frequency of a single character in the current window
            maxFreq = Math.max(maxFreq, charCount[s.charAt(right) - 'A']);

            // If the window is invalid (too many replacements needed)
            while ((right - left + 1) - maxFreq > k) {
                // Shrink the window from the left
                charCount[s.charAt(left) - 'A']--;
                left++; // Move the left boundary forward
            }

            // Calculate the maximum length of a valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AABABBA";
        int k = 1;
        int result = solution.characterReplacement(s, k);
        System.out.println("Longest substring length: " + result);
    }
}

// 1. Understanding the Formula:
// We need the entire substring in a window to be identical.
// To make all characters in the window the same, replace the characters that occur less frequently.
// The most frequent character in the window (maxFreq) should ideally dominate.
// Calculate the remaining characters to be replaced:
// Remaining Characters to Replace=windowLength−maxFreq
// Check if replacements are within the allowed limit (k):
//Valid Window Condition: windowLength−maxFreq≤k
// 2. Approach
// Traverse the string using a right pointer, expanding the window at every iteration.
// Track the frequency of characters in the current window using a frequency array (charCount).
// For every window, calculate the most frequent character count (maxFreq).
// Check if the number of replacements required is within the allowed limit. If not, shrink the window by incrementing the left pointer.