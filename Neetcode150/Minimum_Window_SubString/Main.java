package Minimum_Window_SubString;

// 🔹 Intuition
// We need to find the smallest substring in s that contains all characters of t (including frequency).
// This is a Sliding Window + HashMap problem:
// Expand the right pointer (r) until all characters of t are found.
// Shrink the left pointer (l) to minimize the window.
// Track the smallest valid window found.
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        
        // Edge case: If s is shorter than t, it's impossible to find a substring
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        // Frequency map to store required character counts from 't'
        Map<Character, Integer> mapT = new HashMap<>();
        
        // Populate mapT with frequency of each character in 't'
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int required = mapT.size(); // Number of unique characters in 't' that need to be in window
        int l = 0, r = 0; // Left and Right pointers of sliding window
        int create = 0; // Tracks how many required characters are fully matched in the window
        int[] ans = {-1, 0, 0}; // Stores the smallest window [length, start, end]
        
        // Frequency map to track characters in the current window
        Map<Character, Integer> subStringMap = new HashMap<>();
        
        // Expand the right boundary of the window
        while (r < s.length()) {
            char c = s.charAt(r);
            
            // Add current character to subStringMap
            int count = subStringMap.getOrDefault(c, 0);
            subStringMap.put(c, count + 1);
            
            // If 'c' is in 't' and its count in current window matches 't', increase 'create'
            if (mapT.containsKey(c) && subStringMap.get(c).intValue() == mapT.get(c).intValue()) {
                create++;
            }
            
            // Try contracting the window from the left
            while (l <= r && required == create) {
                c = s.charAt(l); // Character at left pointer
                
                // Update the minimum window size
                if (ans[0] == -1 || ans[0] > r - l + 1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                } 
                
                // Remove the leftmost character from the window
                subStringMap.put(c, subStringMap.get(c) - 1);
                
                // If a character goes below its required frequency, decrease 'create'
                if (mapT.containsKey(c) && subStringMap.get(c).intValue() < mapT.get(c).intValue()) {
                    create--;
                }
                
                l++; // Move the left pointer to contract the window
            }
            
            r++; // Expand the right boundary
        }
        
        // If no valid window is found, return an empty string
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

// **Main Class to Test the Solution**
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: s = "ADOBECODEBANC", t = "ABC"
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Smallest window: " + solution.minWindow(s, t)); // Expected: "BANC"

        // Test Case 2: s = "a", t = "a"
        s = "a";
        t = "a";
        System.out.println("Smallest window: " + solution.minWindow(s, t)); // Expected: "a"

        // Test Case 3: s = "a", t = "aa"
        s = "a";
        t = "aa";
        System.out.println("Smallest window: " + solution.minWindow(s, t)); // Expected: ""
    }
}

// 1️⃣ Create a Frequency Map (mapT) for t
// Stores the count of each character needed from t.
// 2️⃣ Expand the Right Pointer (r)
// Keep adding characters to subStringMap and track matches (create).
// 3️⃣ Shrink the Left Pointer (l)
// Once all required characters are present, shrink from the left to minimize the window.
// 4️⃣ Update the Smallest Window
// Track the smallest valid window using ans[0].