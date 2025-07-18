package Valid_Parenthesis;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        
        // **1️⃣ Create a mapping of closing brackets to their corresponding opening brackets**
        HashMap<Character, Character> mappedBrackets = new HashMap<>();
        mappedBrackets.put(')', '(');
        mappedBrackets.put('}', '{');
        mappedBrackets.put(']', '[');

        // **2️⃣ Use a stack to store opening brackets**
        Stack<Character> stack = new Stack<>();

        // **3️⃣ Iterate through each character in the string**
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // **4️⃣ If it's an opening bracket, push it to the stack**
            if (!mappedBrackets.containsKey(c)) {
                stack.push(c);
            } 
            else { 
                // **5️⃣ If it's a closing bracket, check if there's a matching opening bracket**
                
                // If the stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Get the top element of the stack
                char topElement = stack.pop();

                // If the top element doesn't match the expected opening bracket, return false
                if (topElement != mappedBrackets.get(c)) {
                    return false;
                }
            }
        }

        // **6️⃣ If the stack is empty, all brackets were matched correctly**
        return stack.isEmpty();
    }
}

// **Main Class to Test the Solution**
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // **Test Cases**
        System.out.println(solution.isValid("()"));        // ✅ Expected Output: true
        System.out.println(solution.isValid("()[]{}"));    // ✅ Expected Output: true
        System.out.println(solution.isValid("(]"));        // ❌ Expected Output: false
        System.out.println(solution.isValid("([)]"));      // ❌ Expected Output: false
        System.out.println(solution.isValid("{[]}"));      // ✅ Expected Output: true
        System.out.println(solution.isValid(""));          // ✅ Expected Output: true (empty string is valid)
        System.out.println(solution.isValid("("));         // ❌ Expected Output: false
        System.out.println(solution.isValid("]"));         // ❌ Expected Output: false
    }
}

// Explanation of Key Steps
// 1️⃣ Create a Mapping of Closing to Opening Brackets
// Why? It helps us quickly check which opening bracket corresponds to a closing bracket.
// 2️⃣ Use a Stack to Track Opening Brackets
// When we encounter an opening bracket, we push it onto the stack.
// When we encounter a closing bracket, we check if it matches the last pushed opening bracket.
// 3️⃣ Iterate Through Each Character
// If it's an opening bracket ((, {, [), push it onto the stack.
// If it's a closing bracket (), }, ]):
// Check if the stack is empty (if it is, return false).
// Pop the top of the stack and check if it matches the expected opening bracket.
// 4️⃣ Return True Only if the Stack is Empty
// After iterating, if there are leftover opening brackets in the stack, return false.