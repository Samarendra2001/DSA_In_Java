package KoKo_Eatin_Bananas;

// This is a Binary Search problem:

// Define the search range:

// The slowest possible eating speed is 1 banana/hour.
// The fastest possible speed is max(piles[]), i.e., eating the largest pile in one hour.
// Perform Binary Search:

// Pick a mid value (potential eating speed).
// Check if Koko can finish all bananas at speed mid in h hours (canFinish() function).
// If yes, try a smaller speed (move right to mid).
// If no, increase speed (left = mid + 1).
// Return left as the minimum speed.
import java.util.*;

public class Solution {
    
    public static int minEatingSpeed(int[] piles, int h) {
        // The minimum speed is 1 banana/hour
        int left = 1;
        
        // The maximum speed is the largest pile (Koko eats the biggest pile in 1 hour)
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Apply Binary Search on speed
        while (left < right) {
            int mid = left + (right - left) / 2; // Midpoint of search space
            
            if (canFinish(piles, mid, h)) {
                // If Koko can finish at speed `mid`, try a smaller speed
                right = mid;
            } else {
                // If Koko cannot finish, increase speed
                left = mid + 1;
            }
        }

        // `left` is the minimum speed that allows Koko to finish within `h` hours
        return left;
    }

    // Function to check if Koko can finish all bananas at a given speed
    private static boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0; // Total hours needed
        
        for (int pile : piles) {
            // Compute time required for this pile at given speed
            hours += Math.ceil((double) pile / speed);
        }

        // If total hours <= h, then Koko can finish in time
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Minimum Speed: " + minEatingSpeed(piles, h)); // Expected Output: 4
    }
}

