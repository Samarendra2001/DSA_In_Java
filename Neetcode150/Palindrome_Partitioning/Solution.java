package Palindrome_Partitioning;
// 🔹 Approach (Backtracking + Recursion)
// Use backtracking to explore all possible partitions.
// Check if a substring is a palindrome before adding it to the current partition.
// Recursively explore the remaining part of the string.
// Backtrack by removing the last added substring and try another partitioning.

import java.util.*;

class Solution {
    
    // Main function to partition the string into all possible palindromic substrings
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>(); // Stores all valid partitions
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    // Backtracking function to generate partitions
    private void backtrack(List<List<String>> result, List<String> current, String s, int start) {
        
        // ✅ Base Case: If we have reached the end of the string, add the partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(current)); // Store the partition
            return;
        }

        // ✅ Try every possible substring from 'start' to 'end'
        for (int end = start; end < s.length(); end++) {

            // If the substring from start to end is a palindrome, add it to the current partition
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1)); // Choose this palindrome substring
                backtrack(result, current, s, end + 1); // Explore further partitions
                current.remove(current.size() - 1); // Backtrack and remove last added partition
            }
        }
    }

    // Function to check if a substring is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) { // If mismatch found, return false
                return false;
            }
        }
        return true; // The substring is a palindrome
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String s1 = "aab";
        System.out.println("Partitions for '" + s1 + "': " + solution.partition(s1));

        // Test case 2
        String s2 = "racecar";
        System.out.println("Partitions for '" + s2 + "': " + solution.partition(s2));

        // Test case 3
        String s3 = "abc";
        System.out.println("Partitions for '" + s3 + "': " + solution.partition(s3));
    }
}
// Output:
// Partitions for 'aab': [[a, a, b], [aa, b]]
// 1. Start at index 0:
//    - "a" is a palindrome → Add to current partition → ["a"]
//      - Move to index 1:
//        - "a" is a palindrome → Add to current partition → ["a", "a"]
//          - Move to index 2:
//            - "b" is a palindrome → Add to current partition → ["a", "a", "b"]
//            - Reached end → Add ["a", "a", "b"] to result
//          - Backtrack → Remove "b" → ["a", "a"]
//        - Backtrack → Remove "a" → ["a"]
//      - "aa" is a palindrome → Add to current partition → ["aa"]
//        - Move to index 2:
//          - "b" is a palindrome → Add to current partition → ["aa", "b"]
//          - Reached end → Add ["aa", "b"] to result
//        - Backtrack → Remove "b" → ["aa"]
//      - Backtrack → Remove "aa" → []
//    - "aab" is NOT a palindrome → Ignore
// 2. Final result: `[["a", "a", "b"], ["aa", "b"]]`
