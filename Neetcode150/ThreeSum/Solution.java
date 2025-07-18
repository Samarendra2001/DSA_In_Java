import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//package ThreeSum;

public class Solution {
    public static List<List<Integer>> threeSum(int nums []){
        // Sort the array to make it easier to handle duplicates and use two pointers
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    
    // Iterate over the array, choosing each number as a potential "anchor"
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
        // Skip duplicates to ensure unique triplets
        if (i == 0 || nums[i] != nums[i - 1]) {
            twoSum2(nums, i, result); // Call helper function for remaining numbers
        }
    }

    return result; // Return the list of triplets
    }
    public static void twoSum2(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1; // Pointer to the next number after the anchor
        int right = nums.length - 1; // Pointer to the last number in the array
        
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right]; // Calculate the triplet sum
            
            if (sum < 0) {
                ++left; // Move the left pointer to increase the sum
            } else if (sum > 0) {
                --right; // Move the right pointer to decrease the sum
            } else {
                // Found a triplet that sums to zero
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
    
                // Skip duplicates for the `left` pointer
                while (left < right && nums[left] == nums[left - 1]) {
                    ++left;
                }
            }
        }
    }
    public static void main(String[] args) {
        //Solution solution = new Solution();
        
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        
        System.out.println("Unique Triplets:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
    
    
}
