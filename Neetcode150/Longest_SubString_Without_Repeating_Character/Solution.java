package Longest_SubString_Without_Repeating_Character;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // Step 1: Handle edge cases
        if(s == null || s.length() == 0) {
            return 0; // If the string is null or empty, the result is 0
        }
    
        if(s.length() == 1) {
            return 1; // If the string has just one character, the longest substring is the string itself
        }
    
        // Step 2: Initialize pointers and answer
        int left = 0;    // Left pointer for the sliding window
        int right = 0;   // Right pointer for the sliding window
        int ans = 0;     // Stores the length of the longest substring
    
        // Step 3: Create a HashSet to track unique characters in the current window
        HashSet<Character> set = new HashSet<>();
        
        // Step 4: Expand the right pointer
        while(right < s.length()) {
            char c = s.charAt(right); // Current character at the right pointer
            
            // If character already exists in the set, shrink the window
            while(set.contains(c)) {
                set.remove(s.charAt(left)); // Remove the leftmost character from the set till the duplicate charater remove from the set
                left++; // Move the left pointer to the right
            }
    
            // Add the current character to the set
            set.add(c);
    
            // Update the maximum substring length
            ans = Math.max(ans, right - left + 1);
    
            // Move the right pointer forward
            right++;
        }
    
        // Step 5: Return the result
        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abcabcbb";
        int result = sol.lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters: " + result);
    }
}    
