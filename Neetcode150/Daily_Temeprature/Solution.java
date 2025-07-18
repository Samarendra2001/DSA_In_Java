package Daily_Temeprature;

// Approach
// Initialize an empty stack and an answer array answer[] to store the results.
// Iterate through the temperatures array:
// While the current temperature is greater than the temperature at the top of the stack (indicating a warmer day has arrived for the day at that index):
// Pop the index from the stack.
// Calculate the number of days it took for a warmer temperature to arrive.
// Push the current index onto the stack, as the day hasn't yet found a warmer temperature.
// Return the answer[] array, which contains the number of days for each day.
import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Initialize an array to store the result.
        int n = temperatures.length;
        int[] answer = new int[n];
        
        // Initialize a stack to track indices of the temperatures.
        Stack<Integer> stack = new Stack<>();

        // Traverse through the temperatures array.
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is greater
            // than the temperature of the day stored at the top of the stack,
            // this indicates we've found a warmer day.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // Pop the index from the stack and calculate the number of days.
                int index = stack.pop();
                answer[index] = i - index;  // Number of days to the warmer temperature.
            }
            // Push the current day index onto the stack.
            stack.push(i);
        }

        // Return the result array which contains the number of days until a warmer temperature for each day.
        return answer;
    }

    public static void main(String[] args) {
        // Test case to run the solution
        Solution solution = new Solution();
        
        // Example input array
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        
        // Call the method to get the answer
        int[] result = solution.dailyTemperatures(temperatures);
        
        // Output the result
        System.out.println("Days until warmer temperature: ");
        for (int day : result) {
            System.out.print(day + " ");
        }
    }
}


