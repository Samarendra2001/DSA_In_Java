//package Merge_Intervals;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static int[][] merge(int[][] intervals){
        if(intervals.length==0){
            return new int[][]{};
        }
        //sort intervals based on start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        // Initialize the current interval to the first interval in the sorted list
        int[] currentInterval = intervals[0];
        // Add the current interval to the merged list
        merged.add(currentInterval);
        for(int[] interval : intervals){
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            if(nextBegin <= currentEnd){ //overlapping intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String args[]){
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [][] result = merge(intervals);
        System.out.println("Merge Intervals Problem Solution:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
