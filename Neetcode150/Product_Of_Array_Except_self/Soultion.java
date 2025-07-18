package Product_Of_Array_Except_self;

import java.util.Arrays;

public class Soultion {
    public static int[] product_Of_Array_Except_self(int nums[]){
        int result[]= new int[nums.length];//result are initialized of length same as num
        Arrays.fill(result,1);//initializes the value with 1 
        int preFix = 1;
        for(int i=0;i<nums.length;i++){
            result[i] = preFix; //result[0] = 1 bcz in 0th index 1 is there for this array[1,2,3,4]
            preFix = preFix* nums[i];//similarly prefix of 2 is 1*1 = 1 bcz 2 is in 1st index
        }
        int postFix = 1;
        for(int i= nums.length-1;i>=0;i--){//reverse order for post fix
            result[i] = postFix*result[i];//just multiplying with the result
            postFix = postFix*nums[i];//for 3 post fix = 1*nums[3] = 1*4 = 4
        }
        return result;
    }
    public static void main(String[] args) {
        int arr [] = {1,2,3,4};
        int result[] = product_Of_Array_Except_self(arr);
        System.out.println("Products of array are " + Arrays.toString(result));
    }
}
