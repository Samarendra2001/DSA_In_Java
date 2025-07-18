package Car_Fleet;

// Intuition
// The problem requires us to determine the number of car fleets that will reach the target. A fleet is a group of cars that move together at the same speed.

// Each car will take a certain amount of time to reach the target based on its speed.
// If a slower car is ahead of a faster car, the faster car will eventually catch up and form a fleet.
// By sorting cars by their starting position (from closest to farthest from the target), we can process them in order and count how many separate fleets are formed.
import java.util.Arrays;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Step 1: Store (position, timeToReachTarget) for each car
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];  // Time to reach target
        }

        // Step 2: Sort cars by position in descending order (furthest car first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int count = 0;  // Count of fleets
        double prevTime = 0;  // Tracks last fleet's time to reach target

        // Step 3: Iterate through cars and count fleets
        for (double[] car : cars) {
            if (car[1] > prevTime) {  // If current car takes longer, it forms a new fleet
                count++;
                prevTime = car[1];  // Update the fleet's arrival time
            }
        }

        return count;  // Total number of fleets
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        int result = solution.carFleet(target, position, speed);
        System.out.println("Number of car fleets: " + result);  // Expected Output: 3
    }
}

// Explanation of Code
// Step 1: Compute Each Car's Time to Reach the Target

// We store the time taken for each car using:
// time = target−position/speed ​
 
// Step 2: Sorting Cars by Position

// Sorting ensures that we process cars in order of distance from the target.
// This way, we can check if a car catches up with the one ahead of it.
// Step 3: Counting Fleets

// We iterate through the sorted list.
// If a car's time is greater than prevTime, it forms a new fleet.
// Otherwise, it joins the existing fleet.
// Complexity Analysis
// Sorting step: O(nlogn)
// Single pass iteration: O(n)
// Overall Complexity: O(nlogn) due to sorting.