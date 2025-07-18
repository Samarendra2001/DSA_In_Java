package Generate_Parentheses;
//intuition
// To generate all valid sequences efficiently, we use Backtracking:

// We maintain a current string (cur) as we explore different possibilities.
// We track how many open ( and close ) parentheses have been placed.
// Base case: If the string reaches length 2*n, it's a valid sequence, so we add it to the result.
// Recursive case: Try placing ( if possible, then try placing ) if valid.
import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>(); // Stores the final list of valid parentheses
        backtrack(ans, new StringBuilder(), 0, 0, n); // Start backtracking
        return ans; // Return the list of valid combinations
    }

    /**
     * Recursive function to generate valid parentheses combinations.
     *
     * ans   List to store the valid sequences.
     * cur   The current sequence being formed.
     * open  Number of '(' used so far.
     * close Number of ')' used so far.
     * max   Total pairs of parentheses needed.
     */
    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        // Base Case: If we have formed a valid sequence of length 2 * n, add it to the result
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        // Recursive Case: Try placing '(' if we haven't placed 'n' of them yet
        if (open < max) {
            cur.append("("); // Add an open parenthesis
            backtrack(ans, cur, open + 1, close, max); // Recursively add the next character
            cur.deleteCharAt(cur.length() - 1); // Undo the change (backtrack)
        }

        // Recursive Case: Try placing ')' if it won't create an invalid sequence
        if (close < open) {
            cur.append(")"); // Add a closing parenthesis
            backtrack(ans, cur, open, close + 1, max); // Recursively add the next character
            cur.deleteCharAt(cur.length() - 1); // Undo the change (backtrack)
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        System.out.println(solution.generateParenthesis(3)); 
        // Expected output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}

