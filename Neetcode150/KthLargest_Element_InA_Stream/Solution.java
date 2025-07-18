package KthLargest_Element_InA_Stream;
// 🚀 Intuition:
// We need to maintain the k-th largest element at any given point.
// The best way to do this efficiently is to use a Min-Heap (PriorityQueue) of size k.
// The smallest element in the heap will always be the k-th largest element.
// If we add a new element:
// If the heap has less than k elements, add it directly.
// If the heap has k elements and the new element is greater than the smallest (top), remove the smallest and insert the new value.
// The top of the heap (peek()) will always store the k-th largest element.
// 📌 Approach:
// Constructor (KthLargest(int k, int[] nums))
// Initialize a Min-Heap of size k.
// Insert all elements from nums using the add() method.
// Method add(int val)
// If the heap has fewer than k elements, insert the new value.
// If the heap is full (size == k) and the new value is larger than the smallest, remove the smallest and insert the new value.
// Return the smallest element in the heap (which is the k-th largest).

import java.util.PriorityQueue;

class Solution {
    private PriorityQueue<Integer> minHeap; // Min-Heap to store k largest elements
    private int k; // The kth largest element to track

    // Constructor to initialize the object with k and the initial nums array
    public Solution(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k); // Min-Heap of size k

        // Add all elements from nums to the heap
        for (int num : nums) {
            add(num);
        }
    }

    // Adds a new value to the data stream and returns the kth largest element
    public int add(int val) {
        if (minHeap.size() < k) {
            // If the heap has less than k elements, add directly
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            // If the new value is greater than the smallest, replace the smallest
            minHeap.poll(); // Remove the smallest element
            minHeap.offer(val); // Add the new value
        }

        // Return the kth largest element (smallest element in the heap)
        return minHeap.peek();
    }

    // Main function for testing the class
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2}; // Initial elements
        Solution kthLargest = new Solution(k, nums);

        // Adding new elements and getting the kth largest
        System.out.println(kthLargest.add(3));  // Output: 4
        System.out.println(kthLargest.add(5));  // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9));  // Output: 8
        System.out.println(kthLargest.add(4));  // Output: 8
    }
}
