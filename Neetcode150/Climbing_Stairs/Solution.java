package Climbing_Stairs;

public class Solution {
    public static int climbStairs(int n){
        // base cases 
        if (n==0 || n==1) return 1;

        // // create an array to store the number of ways to reach each step
        // int[] dp = new int[n+1];
        // // there is 1 way to reach the 0th step and 1 way to
        // dp[0] = 1;
        // dp[1] = 1;
        // // fill the dp array
        // for (int i =2;i<=n;i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];

        // space optimized approach without using array
        int first = 1; // ways to reach step 0
        int second = 1; // ways to reach step 1
        for(int i =2;i<=n;i++){
            int current = first + second;
            first = second;
            second = current;
        }
        return second;
    }
    // recursive approach with memoization
    // public static int climbStairs(int n, int[] memo){
    //  base cases
    //     if (n==0 || n==1) return 1;
    //     if (memo[n] !=0) return memo[n]; // check if we have already computed the value for n as 0 is initial value in java arrays
    //     memo[n] = climbStairs(n-1,memo) + climbStairs(n-2,memo);// store the computed value in memo array..memo array is being passed by reference to the recursive calls else we will lose the computed values.
    //     return memo[n];
    // }
    
   public static void main(String args[]){
       System.out.println("Total number of ways to climb stairs: " + climbStairs(5)); // Output: 8
   }

   // Example usage of recursive approach with memoization
   // public static void main(String args[]){
    //     int n = 5;
    //     int[] memo = new int[n+1]; // initialize memoization array with size n+1 because we need to store results from 0 to n so we need n+1 spaces..
    // And in java, arrays are zero-indexed. and this array in java will be initialized with all elements as 0 by default. in c++ it is -1 by default. So we check for 0 in the code above..
    //     System.out.println("Total number of ways to climb stairs (recursive with memoization): " + climbStairs(n, memo)); // Output: 8
   // }
}
