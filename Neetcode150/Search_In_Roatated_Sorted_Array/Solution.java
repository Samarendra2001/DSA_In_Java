// 🚀 Intuition:
// We are given a rotated sorted array and need to find the index of a target element.
// Even though the array is rotated, at least one half is always sorted.
// Using Binary Search:
// We can efficiently determine which half is sorted.
// Then decide whether the target lies in the sorted half or the unsorted half.
// 🔍 Approach:
// Binary Search:
// Use two pointers, left and right, to perform binary search.
// Find the middle index: mid = (left + right) / 2.
// Check if the middle element is the target:
// If yes, return the index.
// Determine the sorted half:
// If nums[left] <= nums[mid], then the left half is sorted.
// Check if the target is within the range nums[left] to nums[mid].
// If yes, narrow the search to the left half.
// Otherwise, move to the right half.
// Else, the right half is sorted.
// Check if the target is within the range nums[mid] to nums[right].
// If yes, narrow the search to the right half.
// Otherwise, move to the left half.
// Continue until left > right.
// Return -1 if the target is not found.

package Search_In_Roatated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        
        // Initialize two pointers for binary search
        int left = 0;
        int right = nums.length - 1;
        
        // Binary search loop
        while (left <= right) {
            // Calculate the mid index
            int mid = (left + right) / 2;
            
            // Check if the mid element is the target
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                
                // If the target is NOT in the sorted left half, search right half
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } 
                // Else, search in the left half
                else {
                    right = mid - 1;
                }
            } 
            // Else, the right half must be sorted
            else {
                
                // If the target is NOT in the sorted right half, search left half
                if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                } 
                // Else, search in the right half
                else {
                    left = mid + 1;
                }
            }
        }
        
        // If the target is not found, return -1
        return -1;
    }
    
    // Main method to test the solution with different cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Target is present in the rotated array
        int[] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        System.out.println("Index of " + target1 + ": " + sol.search(nums1, target1)); // Output: 4

        // Test Case 2: Target is not present in the rotated array
        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        System.out.println("Index of " + target2 + ": " + sol.search(nums2, target2)); // Output: -1

        // Test Case 3: Array with one element, target is present
        int[] nums3 = {1};
        int target3 = 1;
        System.out.println("Index of " + target3 + ": " + sol.search(nums3, target3)); // Output: 0

        // Test Case 4: Array with no rotation, target is present
        int[] nums4 = {1,2,3,4,5,6,7};
        int target4 = 6;
        System.out.println("Index of " + target4 + ": " + sol.search(nums4, target4)); // Output: 5
        
        // Test Case 5: Target is the first element after rotation
        int[] nums5 = {6,7,8,9,1,2,3,4,5};
        int target5 = 6;
        System.out.println("Index of " + target5 + ": " + sol.search(nums5, target5)); // Output: 0
        
        // Test Case 6: Target is the last element
        int[] nums6 = {6,7,8,9,1,2,3,4,5};
        int target6 = 5;
        System.out.println("Index of " + target6 + ": " + sol.search(nums6, target6)); // Output: 8
    }
}

