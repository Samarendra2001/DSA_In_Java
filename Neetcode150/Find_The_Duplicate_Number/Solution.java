package Find_The_Duplicate_Number;
// Intuition / Logic
// The problem can be treated like detecting a cycle in a linked list.
// Treat each value in the array as a pointer. For example, nums[i] points to nums[nums[i]].
// The duplicate number forms a cycle, i.e., the duplicate number causes a loop in the array pointers.
// To find the duplicate efficiently:

// Use Floyd's Tortoise and Hare algorithm (Cycle detection algorithm).
// Cycle detection: Fast pointer moves two steps at a time, slow pointer moves one step at a time. If there's a cycle, they will meet.
// Cycle entrance: After they meet, reset one pointer to the start, and move both one step at a time to find the entrance of the cycle, which is the duplicate.


public class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize the slow and fast pointers
        int slow = nums[0];              // Slow pointer starts from the first element
        int fast = nums[nums[0]];        // Fast pointer starts two steps ahead
        
        // Find the intersection point of the two runners (Cycle detection)
        while (slow != fast) {
            slow = nums[slow];           // Move slow pointer one step
            fast = nums[nums[fast]];     // Move fast pointer two steps
        }
        
        // Now that slow and fast meet, find the "entrance" to the cycle (duplicate number)
        slow = 0;  // Reset slow pointer to the start
        while (slow != fast) {
            slow = nums[slow];           // Move both slow and fast pointers one step at a time
            fast = nums[fast];
        }
        
        return slow;  // The point where slow and fast meet is the duplicate number
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Duplicate is 2
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number in nums1: " + solution.findDuplicate(nums1)); // Expected output: 2
        
        // Test case 2: Duplicate is 3
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number in nums2: " + solution.findDuplicate(nums2)); // Expected output: 3
    }
}

// 🔹 Example Walkthrough
// Example 1:
// nums = [1, 3, 4, 2, 2]
// Step 1 (Cycle Detection):

// slow = nums[0] = 1, fast = nums[nums[0]] = nums[1] = 3
// slow moves to nums[slow] = 3, fast moves to nums[nums[fast]] = nums[nums[3]] = 2
// slow moves to nums[slow] = 2, fast moves to nums[nums[fast]] = nums[nums[2]] = 4
// slow moves to nums[slow] = 4, fast moves to nums[nums[fast]] = nums[nums[4]] = 2
// slow moves to nums[slow] = 2, fast moves to nums[nums[fast]] = nums[nums[2]] = 4
// Eventually, slow and fast meet at 2.
// Step 2 (Cycle Entrance):
// Reset slow to 0.
// Both slow and fast move one step at a time:
// slow moves to nums[0] = 1, fast moves to nums[2] = 2
// slow moves to nums[1] = 3, fast moves to nums[3] = 2
// Finally, slow and fast meet at 2, which is the duplicate number.

