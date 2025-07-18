package Evaluate_Reverse_Polish_Notation;
//Intuition
// We can solve this efficiently using a stack:
// Push numbers onto the stack.
// When encountering an operator, pop the last two numbers, apply the operation, and push the result back.
// Final result will be at the top of the stack.
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // Stack to hold numbers

        // Iterate through each token in the input array
        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop the last two operands from the stack
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand

                // Apply the operation and push the result back
                int result = applyOperator(token, a, b);
                stack.push(result);
            } else {
                // Convert number from string to integer and push to stack
                stack.push(Integer.parseInt(token));
            }
        }

        // Final result is at the top of the stack
        return stack.pop();
    }

    /** Helper function to check if a token is an operator */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /** Helper function to apply an operator to two operands */
    private int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division (truncates towards zero)
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // **Main Class to Test the evalRPN**
    public static void main(String[] args) {
        Solution solution = new Solution();

        // **Test Cases**
        String[] expression1 = {"2", "1", "+", "3", "*"};  // (2 + 1) * 3 = 9
        System.out.println(solution.evalRPN(expression1)); // ✅ Expected Output: 9

        String[] expression2 = {"4", "13", "5", "/", "+"};  // 4 + (13 / 5) = 6
        System.out.println(solution.evalRPN(expression2)); // ✅ Expected Output: 6

        String[] expression3 = {"10", "6", "9", "3", "/", "-", "*"}; // 10 * (6 - (9/3)) = 30
        System.out.println(solution.evalRPN(expression3)); // ✅ Expected Output: 30
    }
}

// 1️⃣ Using a Stack for Evaluation
// The stack stores numbers until an operator is encountered.
// When an operator appears:
// Pop two numbers from the stack.
// Perform the operation.
// Push the result back onto the stack.
// 2️⃣ Checking for Operators (isOperator())
// This function simply checks if a token is one of +, -, *, or /.
// 3️⃣ Performing Operations (applyOperator())
// Uses a switch-case to perform addition, subtraction, multiplication, or division.
// Division uses integer division, truncating towards zero.