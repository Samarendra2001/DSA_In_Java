//package Gas_Station;

public class Solution {
    public static int gasStation(int[] gas, int [] cost){
        int totalGas =0, totalCost = 0, currentGas =0, startingPoint =0;
        for(int i =0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas = currentGas+gas[i] - cost[i];
            if(currentGas<0){
                startingPoint = i+1;
                currentGas =0;
            }
        }
        return totalGas<totalCost ? -1 : startingPoint;
    }
    public static void main(String args[]){
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};
        System.out.println("Gas Station Problem Solution: " + gasStation(gas,cost));
    }
}
