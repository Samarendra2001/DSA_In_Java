package Permutation_String;

// Intuition
// We need to check if any permutation of s1 exists as a contiguous substring in s2.
// Since permutations only rearrange characters, both s1 and a valid substring in s2 must have the same character frequency.
// We use sliding window + frequency arrays to efficiently check if any window in s2 matches s1.
// **Solution Class**
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, it's impossible to find a permutation
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26]; // Frequency array for s1
        int[] s2Map = new int[26]; // Frequency array for current window in s2

        // Initialize the frequency arrays with first s1.length() characters
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;  // Increment count for s1 character
            s2Map[s2.charAt(i) - 'a']++;  // Initialize first window in s2
        }

        // Slide the window across s2 and compare character frequencies
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Map, s2Map)) {  // Check if current window is a permutation
                return true;
            }

            // Slide the window: add the next character & remove the old character
            s2Map[s2.charAt(i + s1.length()) - 'a']++; // Add new character to window
            s2Map[s2.charAt(i) - 'a']--; // Remove old character from window
        }

        // Check the last window after exiting the loop
        return matches(s1Map, s2Map);
    }

    // **Helper function to compare two frequency arrays**
    private boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {  // If frequencies don’t match, return false
                return false;
            }
        }
        return true;
    }

// **Main Class to Test the Solution**
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: s1 = "ab", s2 = "eidbaooo"
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("Permutation exists? " + solution.checkInclusion(s1, s2)); // Expected: true

        // Test Case 2: s1 = "abc", s2 = "ccccbbbbaaaa"
        s1 = "abc";
        s2 = "ccccbbbbaaaa";
        System.out.println("Permutation exists? " + solution.checkInclusion(s1, s2)); // Expected: false

        // Test Case 3: s1 = "hello", s2 = "ooolleoooleh"
        s1 = "hello";
        s2 = "ooolleoooleh";
        System.out.println("Permutation exists? " + solution.checkInclusion(s1, s2)); // Expected: false
    
    }
}
