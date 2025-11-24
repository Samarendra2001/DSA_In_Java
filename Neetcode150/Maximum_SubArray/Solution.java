//package Maximum_SubArray;

public class Solution {
    public static int maxSubArray(int[] nums){
        int currentSum = 0;
        int maxSum = nums[0];
        for(int i=0;i<nums.length;i++){
            currentSum += nums[i];
            if(currentSum>maxSum){
                maxSum = currentSum;
            }
            if (currentSum<0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String args[]){
        int [] nums = {-3,2,-5,8,-1,2,3,-5};
        System.out.println("Maximum Subarray Sum is: " + maxSubArray(nums));
    }
}
