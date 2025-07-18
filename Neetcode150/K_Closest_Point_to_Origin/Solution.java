package K_Closest_Point_to_Origin;
// 🚀 Intuition
// We need to find the k closest points to the origin (0,0).
// The distance formula:Since we are calculating the distance from the origin 
//the formula simplifies to:
// distance=x^2+y^2
 //and we dont have to take the square root since we know that the bigger the square of a number the bigger the number itself
// We don't take the square root since we only care about relative distances.
// We use a Max-Heap (Priority Queue) to keep track of the k smallest distances.
// A Max-Heap allows us to efficiently remove the farthest point when adding a new closer point.
// If the heap size exceeds k, we remove the farthest point.
// 📌 Approach
// Use a Max-Heap (PriorityQueue):

// The heap stores k elements based on the negative distance from (0,0).
// Java's PriorityQueue by default is a Min-Heap, so we reverse the comparison to make it a Max-Heap.
// Iterate through each point:

// Add the point to the heap.
// If the heap size exceeds k, remove the farthest point.
// Extract k closest points from the heap.



import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a max-heap (priority queue) to store k closest points
        // Comparator sorts points in descending order based on distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(
                        (b[0] * b[0] + b[1] * b[1]),  // Distance of b from origin
                        (a[0] * a[0] + a[1] * a[1])   // Distance of a from origin
                )
        );

        // Iterate through each point and process them
        for (int[] point : points) {
            maxHeap.add(point); // Add point to heap

            // If the heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract k closest points from the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll(); // Remove points from heap and store them in result
        }

        return result; // Return the k closest points
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        // Call the function
        int[][] result = solution.kClosest(points, k);
        
        // Print output
        System.out.println("K Closest Points: " + Arrays.deepToString(result));
    }
}

