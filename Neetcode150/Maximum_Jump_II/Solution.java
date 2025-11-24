//package Maximum_Jump_II;

public class Solution {
    public static int maxJumpII(int nums[]){
        int jumps =0, currentEnd = 0, currentMax =0;
        for(int i =0;i<nums.length-1;i++){
            currentMax = Math.max(currentMax,i+nums[i]);
            if(i == currentEnd){
                jumps++;
                currentEnd = currentMax;
            }
        }
        return jumps;
    }
    public static void main(String args[]){
        int [] nums = {1,3,1,3,1,1,1,2};
        System.out.println("Maximum Jump II Problem Solution: " + maxJumpII(nums));
    }
}
