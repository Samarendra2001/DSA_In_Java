//package Insert_Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int [][] insert(int [][] intervals, int [] newInterval){
        List<int[]> result = new ArrayList<>();
        int i =0;
        //add all intervals before newInterval
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        // merge overlapping intervals
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        // add all intervals after newInterval
        while(i<intervals.length){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String args[]){
        int [][] intervals = {{1,3},{6,9}};
        int [] newInterval = {2,5};
        int [][] result = insert(intervals,newInterval);
        System.out.println("Insert Interval Problem Solution:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
