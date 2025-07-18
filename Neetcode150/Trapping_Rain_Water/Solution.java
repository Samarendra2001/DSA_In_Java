package Trapping_Rain_Water;

public class Solution {
    public static int trap(int[] height) {
        // Two pointers to traverse the array from both ends
        int left = 0;
        int right = height.length - 1;
    
        // Total water trapped
        int total = 0;
    
        // Tracking the maximum heights on the left and right
        int leftMax = height[0];
        int rightMax = height[right];
    
        // Loop until the two pointers meet
        while (left < right) {
            // If the height at 'left' is less than the height at 'right'
            if (height[left] < height[right]) {
                // Update leftMax to the maximum of leftMax or current height at left
                leftMax = Math.max(leftMax, height[left]);
    
                // Calculate the trapped water for current position (leftMax - height[left])
                if (leftMax - height[left] > 0) {
                    total = total + (leftMax - height[left]);
                }
    
                // Move the left pointer to the right
                left++;
            } else {
                // Otherwise, handle the 'right' side in the same way
                rightMax = Math.max(rightMax, height[right]);
    
                // Calculate the trapped water for current position (rightMax - height[right])
                if (rightMax - height[right] > 0) {
                    total = total + (rightMax - height[right]);
                }
    
                // Move the right pointer to the left
                right--;
            }
        }
    
        // Return the total water trapped
        return total;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
    
        // Test case: Example elevation map
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    
        // Call the `trap` method to calculate trapped water
        int result = solution.trap(height);
    
        // Output the result
        System.out.println("Water trapped: " + result);
    }
    
}
