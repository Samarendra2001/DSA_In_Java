package TwoSumm;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int nums[],int target){ // this means we are returning a new array
        //create a Hasmap to store number and their indices
        Map<Integer,Integer> map = new HashMap<>();
        //iterate through the array
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
        //check if the complement is alrady present in the map
            if(map.containsKey(complement)){
                //if found returnn the indices of the complement and the current number in a new array
                return new int[]{map.get(complement),i};
            }
            //otherwise, add the current number and its index to themap
            map.put(nums[i],i);
        }
        //return an empty array if no soultion is found
        return new int[]{};
    }
    public static void main(String args[]){
        int arr [] = {2,4,5,1,3,8,9,10};
        int target = 16;
        int result [] = twoSum(arr, target);
        // Print the result
        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found");
        }
    }
}
