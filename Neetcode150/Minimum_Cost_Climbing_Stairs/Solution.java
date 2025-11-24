//package Minimum_Cost_Climbing_Stairs;

public class Solution {
    public static int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        // base cases
        if (n == 0 || n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);
        // space optimized approach without using array and it is not recursive ..it is iterative
        int first = cost[0];
        int second = cost[1];
        for(int i=2;i<n;i++){
            int current = Math.min(first, second) + cost[i];
            first = second;
            second = current;
        }
        return Math.min(first, second);
        //  2nd approach create an array to store the minimum cost to reach each step
        // int[] dp = new int[n+1];
        // dp[0] = 0;
        // dp[1] = 0;
        // for (int i = 2; i <= n; i++) {
        //     dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        // }
        // return dp[n];
    }
    // recursive approach with memoization
    // public static int minCostClimbingStairs(int n, int[] cost, int[] memo){
    //  base cases
    //     if (n == 0) return 0;
    //     if (n == 1) return 0;
    //     if (memo[n] != 0) return memo[n];
    //     memo[n] = Math.min(minCostClimbingStairs(n-1, cost, memo) + cost[n-1],
    //                        minCostClimbingStairs(n-2, cost, memo) + cost[n-2]);
    //     return memo[n];
    // }
    public static void main(String[] args) {
        System.out.println("Minimum cost to climb stairs: " + minCostClimbingStairs(new int[]{10, 15, 20, 25, 30})); // Output: 15
    }
}
    // Example usage of recursive approach with memoization
    // public static void main(String[] args) {
    //     int[] cost = {10, 15, 20, 25, 30};
    //     int n = cost.length;
    //     int[] memo = new int[n+1];
    //     System.out.println("Minimum cost to climb stairs (recursive with memoization): " + minCostClimbingStairs(n, cost, memo));
    // }