package BestTimeToBuyAndSellStock;

public class Solution {
    public static int stockBuyAndSell(int prices[]){
        int profit =0;
        int minPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            if(minPrice>prices[i]){
                minPrice = prices[i];
            }
            profit = Math.max(profit,prices[i]-minPrice);
        }
        return profit;
    }
    public static void main(String args[]){
        int arr [] = {7,1,5,3,6,4};
        int result = stockBuyAndSell(arr);
        System.out.println("Maximum Profit I made today is " + result);
    }
}
