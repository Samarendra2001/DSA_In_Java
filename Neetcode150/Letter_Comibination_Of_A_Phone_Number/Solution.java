package Letter_Comibination_Of_A_Phone_Number;
// 🔹 Intuition
// Imagine you have an old mobile phone with a T9 keypad (like Nokia phones). Each digit (2-9) corresponds to a set of letters. Given a string of digits, we need to find all possible letter combinations by replacing each digit with its corresponding letters.
 import java.util.*;
 //🔹 Approach
// Use a mapping for digits to their corresponding letters (2 -> abc, 3 -> def, etc.).
// Apply backtracking to explore all possible letter combinations:
// Start with an empty string.
// Pick a letter corresponding to the current digit.
// Move to the next digit and repeat.
// If all digits are processed, add the current combination to the result.
// Backtrack (remove last character) to try the next possibility.
// Base Case: When all digits are processed, store the current combination.


class Solution {

    // Mapping of digits to corresponding letters (index 0 and 1 are empty since we don't use them)
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // If input is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Start backtracking to generate all combinations
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // ✅ Base Case: If we have processed all digits, add the combination to the result
        if (index == digits.length()) {
            result.add(current.toString());  // Store the final combination
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = KEYPAD[digits.charAt(index) - '0']; // Convert character to integer index

        // Iterate through all possible letters for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // Choose the letter
            backtrack(result, current, digits, index + 1);  // Explore further
            current.deleteCharAt(current.length() - 1);  // Backtrack (remove last added letter)
        }
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String digits1 = "23";
        System.out.println("Combinations for '" + digits1 + "': " + solution.letterCombinations(digits1));

        String digits2 = "";
        System.out.println("Combinations for '" + digits2 + "': " + solution.letterCombinations(digits2));

        String digits3 = "7";
        System.out.println("Combinations for '" + digits3 + "': " + solution.letterCombinations(digits3));

        String digits4 = "92";
        System.out.println("Combinations for '" + digits4 + "': " + solution.letterCombinations(digits4));
    }
}

