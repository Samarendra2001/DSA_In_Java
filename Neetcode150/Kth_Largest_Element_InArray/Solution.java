package Kth_Largest_Element_InArray;

import java.util.PriorityQueue;

// 🔍 Intuition
// The problem requires us to find the k-th largest element in an array. Instead of sorting the entire array (which takes 
// O(NlogN) time), we can use a min-heap (priority queue) to efficiently track the k largest elements.

// 💡 Approach
// Use a Min-Heap (Priority Queue):

// A min-heap automatically keeps the smallest element at the top.
// We will maintain a heap of size k, containing the k largest elements seen so far.
// Iterate Through the Array:

// Add each element to the heap.
// If the heap size exceeds k, remove the smallest element (so we always keep only the k largest elements).
// Final Answer:

// After processing all elements, the root of the heap will be the k-th largest element.
import java.util.Scanner;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // ✅ Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // ✅ Process each number in the array
        for (int num : nums) {
            minHeap.add(num); // Add to heap
            
            // ✅ If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll(); // This keeps only the k largest elements
            }
        }

        // ✅ The root of the heap is now the k-th largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ✅ Input size and k value
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        
        Solution solution = new Solution();
        int result = solution.findKthLargest(nums, k);
        
        System.out.println("The " + k + "-th largest element is: " + result);
        
        scanner.close();
    }
}

// 🚀 Alternative Approach
// Using QuickSelect Algorithm (Hoare’s Selection Algorithm)

// Uses partitioning like QuickSort to find the k-th largest element.
// Average Time Complexity: O(N)
// Worst Case: O(N^2) (if pivot choices are bad)
// Better for Large Inputs: When k is large.
// Not Stable: The order of equal elements may change.