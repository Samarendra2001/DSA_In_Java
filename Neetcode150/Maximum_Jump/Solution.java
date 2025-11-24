//package Maximum_Jump;

public class Solution {
    public static int maxJump(int nums[]){
        int finall = nums.length -1;
        for(int i = nums.length-2;i>=0;i--){
            if(i+nums[i]>=finall){
                finall = i;
            }
        }
        //with while loop
        // int current = finall -1;
        // while(current>=0){
        //     if(current+nums[current]>=finall){
        //         finall=current;
        //     }
        //     current--;
        // }
        return finall==0 ? 1: 0;
    }
    public static void main(String args[]){
        int [] nums = {3,2,1,0,4};
        System.out.println("Maximum Jump Problem Solution: " + maxJump(nums));
    }
}
