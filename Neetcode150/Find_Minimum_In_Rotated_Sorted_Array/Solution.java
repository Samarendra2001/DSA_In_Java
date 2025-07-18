package Find_Minimum_In_Rotated_Sorted_Array;
// Intuition & Approach Summary:
// Binary Search is used because the array is partially sorted due to rotation.
// If the current window is sorted (nums[left] < nums[right]), then the leftmost element is the smallest.
// If the left half is sorted (nums[left] <= nums[mid]), the minimum is in the right half → Move left = mid + 1.
// Otherwise, the right half is sorted, so the minimum is in the left half → Move right = mid - 1.
// Keep updating the minimum value during the search.
public class Solution {
    public int findMin(int[] nums) {
        
        // Edge Case: If there's only one element, return it
        if(nums.length == 1){
            return nums[0];
        }
        
        // Initialize pointers for Binary Search
        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0]; // Store the minimum element, initialized to the first element
        
        // Binary Search
        while(left <= right){
            
            // If the current window is already sorted, the smallest element is at 'left'
            if(nums[left] < nums[right]){
                ans = Math.min(ans, nums[left]);
                break; // No need to search further
            }
            
            // Calculate mid index
            int mid = (left + right) / 2;
            
            // Update answer with the minimum value encountered so far
            ans = Math.min(ans, nums[mid]);
            
            // If the left half is sorted
            if(nums[left] <= nums[mid]){
                // The minimum is not in the left half, so move to the right half
                left = mid + 1;
            }
            else {
                // The right half is sorted, so the minimum is in the left half
                right = mid - 1;
            }
        }
        
        return ans; // Return the smallest value found
    }

    // Main function to test the code
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {3, 4, 5, 1, 2};
        int[] nums3 = {11, 13, 15, 17};
        int[] nums4 = {2, 1};
        
        System.out.println("Minimum in nums1: " + solution.findMin(nums1)); // Output: 0
        System.out.println("Minimum in nums2: " + solution.findMin(nums2)); // Output: 1
        System.out.println("Minimum in nums3: " + solution.findMin(nums3)); // Output: 11
        System.out.println("Minimum in nums4: " + solution.findMin(nums4)); // Output: 1
    }
}

