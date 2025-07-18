package Last_Stone_Weight;
// 🚀 Intuition
// We need to simulate the process of smashing the two heaviest stones until we are left with either one stone or none.
// The best way to efficiently get the heaviest stones repeatedly is by using a Max-Heap (PriorityQueue in Java with custom comparator).
// The two heaviest stones are removed, and if they are not equal, the difference is added back.
// The process continues until only one stone or none remains.
// 📌 Approach
// Use a Max-Heap (PriorityQueue):

// Java’s PriorityQueue defaults to a Min-Heap, so we use a custom comparator to simulate a Max-Heap ((a, b) -> b - a).
// Insert all elements (stones) into the heap.
// Simulate Stone Smashing:

// While more than one stone exists, remove the two largest stones.
// If the stones have different weights, insert the difference back into the heap.
// Return the Last Remaining Stone (or 0 if none remain).
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a max-heap using a priority queue with a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Continue smashing stones until one or none remains
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // The heaviest stone
            int x = maxHeap.poll(); // The second heaviest stone

            if (x != y) {
                maxHeap.add(y - x); // Add the difference if stones are not equal
            }
        }

        // If no stones remain, return 0; otherwise, return the last stone's weight
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(solution.lastStoneWeight(stones)); // Expected Output: 1
    }
}

