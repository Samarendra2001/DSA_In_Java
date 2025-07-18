package TwoSum_II_InputArrayIs_Sorted;

import java.util.Arrays;

public class Solution {
    public static int[] twoSum(int nums[],int target){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right] > target){
                right--;
            }
            else if(nums[left] + nums[right]< target){
                left++;
            }
            else{
                return new int[]{left+1,right+1};
            }
        }
        return null;
    }
    public static void main(String args[]){
        int nums[] = {3,4,5,6,8,9,12,15};
        int target = 20;
        int result [] = twoSum(nums, target);
        System.out.println("The indexes are " + Arrays.toString(result));
    }
}
